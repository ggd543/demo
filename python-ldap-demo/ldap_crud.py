#!usr/bin/env python
#coding: utf-8

__author__ = 'Administrator'

import sys, ldap

LDAP_HOST = 'ldaps://192.168.121.130:636'
# LDAP_PORT = 389
LDAP_BASE_DN = 'dc=ggd543,dc=com'
MGR_CRED = 'cn=admin,dc=ggd543,dc=com'
MGR_PASSWD = '123456'
person_FILTER = 'cn=test1'


class PersonLDAP:
    def __init__(self, ldap_host=None, ldap_base_dn=None, mgr_cred=None, mgr_passwd=None):
        if not ldap_host:
            ldap_host = LDAP_HOST
        if not ldap_base_dn:
            ldap_base_dn = LDAP_BASE_DN
        if not mgr_cred:
            mgr_cred = MGR_CRED
        if not mgr_passwd:
            mgr_passwd = MGR_PASSWD
        ldap.set_option(ldap.OPT_X_TLS_REQUIRE_CERT, ldap.OPT_X_TLS_ALLOW)
        self.ldapconn = ldap.initialize(ldap_host)
        self.ldapconn.simple_bind(mgr_cred, mgr_passwd)
        self.ldap_base_dn = ldap_base_dn

    def list_persons(self, person_filter=None, attrib=None):
        if not person_filter:
            person_filter = person_FILTER
        s = self.ldapconn.search_s(self.ldap_base_dn, ldap.SCOPE_SUBTREE, person_filter, attrib)
        print "Here is the complete list of persons: ", s;
        person_list = []
        for person in s:
            attrib_dict = person[1]
            if (attrib != None):
                for a in attrib:
                    out = "%s: %s" % (a, attrib_dict[a])
                    print out
                    person_list.append(out)
            else:
                print attrib_dict;
                person_list.append(attrib_dict);
        return person_list

    def add_person(self, person_name, person_ou, person_info):
        person_dn = 'uid=%s,ou=%s,%s' % (person_name, person_ou, self.ldap_base_dn)
        person_attrib = [(k, v) for (k, v) in person_info.items()]
        print "Adding person %s with ou=%s" % (person_name, person_ou)
        self.ldapconn.add_s(person_dn, person_attrib)

    def modify_person(self, person_name, person_ou, person_attrib):
        person_dn = 'uid=%s,ou=%s,%s' % (person_name, person_ou, self.ldap_base_dn)
        print "Modifying person %s with ou=%s" % (person_name, person_ou)
        self.ldapconn.modify_s(person_dn, person_attrib)

    def delete_person(self, person_name, person_ou):
        person_dn = 'uid=%s,ou=%s,%s' % (person_name, person_ou, self.ldap_base_dn)
        print "Deleting person %s with ou=%s" % (person_name, person_ou)
        self.ldapconn.delete_s(person_dn)

    def authenticate(self, person_name, person_ou, password):
        person_dn = 'uid=%s,ou=%s,%s' % (person_name, person_ou, self.ldap_base_dn)
        res= self.ldapconn.compare_s(person_dn,'userPassword',password)
        print 'auth result: ', res


if __name__ == "__main__":
    l = PersonLDAP();
    l.list_persons(attrib=['cn', 'userPassword']);

    print '\n'
    # add new stooge: Harry Potter
    person_name = 'Harry Potter'
    person_ou = 'Tester'
    person_info = {
                    'cn': ['Harry Potter'], 'sn': ['Harry'], 'cn': ['Harry'],
                   'objectClass': ['inetOrgPerson'], 'uid': ['harry'],
                   'title': ['QA Engineer'], 'facsimileTelephoneNumber': ['800-555-3318'],
                   'userPassword' : ['harrysecret'], 'postalCode': ['75206'], 'mail': ['HPotter@unisonis.com'],
                   'labeledURI': ['http://www.oschina.net']
    }
    try:
        l.add_person(person_name, person_ou, person_info)
    except ldap.LDAPError, error:
        print 'problem with ldap', error

    # now modify home phone
    stooge_modified_attrib = [(ldap.MOD_REPLACE, 'labeledURI', 'http://www.baidu.com')]
    try:
        l.modify_person(person_name, person_ou, stooge_modified_attrib)
    except ldap.LDAPError, error:
        print 'problem with ldap', error

    print '\n'
    l.authenticate(person_name,person_ou,'harrysecret')
    l.authenticate(person_name,person_ou,'**harrysecret')

    print '\n'
    # now delete Harry Potter
    try:
        l.delete_person(person_name, person_ou)
    except ldap.LDAPError, error:
        print 'problem with ldap', error

