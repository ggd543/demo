/**
 * Created with IntelliJ IDEA.
 * User: 刘永健
 * Date: 12-12-15
 * Time: 下午11:26
 * To change this template use File | Settings | File Templates.
 */
package test;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;

import java.util.Collection;
import java.util.Iterator;

public class DroolsModifiyDemo {
    public static void main(String[] args) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("modify.drl"), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println("规则中存在错误: ");
            KnowledgeBuilderErrors errors = kbuilder.getErrors();
            Iterator iterator = errors.iterator();
            while (iterator.hasNext()) {
                KnowledgeBuilderError error = (KnowledgeBuilderError) iterator.next();
                System.out.println(error);
            }
        }
        Collection collection = kbuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(collection);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        Customer customer = new Customer();
        customer.setName("张三");
        customer.setAge(20);
        session.insert(customer);
        session.fireAllRules();

        session.dispose();
        System.out.println("end.");
        // why
    }
}
