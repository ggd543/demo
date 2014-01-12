package com.ggd543.demo.jdo;

import org.exolab.castor.jdo.*;
import org.exolab.castor.mapping.MappingException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-29
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public class CastorJDODemo {

    private static JDOManager createJDOManager() throws MappingException {
        URL confUrl = CastorJDODemo.class.getResource("/jdo/jdo-conf.xml");
        System.out.println(confUrl);
        JDOManager.loadConfiguration(confUrl.toString());
        JDOManager jdoManager = JDOManager.createInstance("mysql");
        return jdoManager;
    }

    public static void main(String[] args) throws MappingException {
        JDOManager jdoManager = createJDOManager();
        testDelete(jdoManager);
//        testAdd(jdoManager);
//        testQuery(jdoManager);
    }

    private static void testQuery(JDOManager jdoManager) {
        Database database = null;
        OQLQuery oql1 = null;
        try {
            database = jdoManager.getDatabase();
            database.begin();
            oql1 = database.getOQLQuery("SELECT p FROM com.ggd543.demo.jdo.Product p");
            QueryResults qr1 = oql1.execute();
            while (qr1.hasMore()) {
                Product p = (Product) qr1.next();
                System.out.println("get product: " + p);
            }
            database.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            rollback(database);
        } finally {
            closeQuery(oql1);
            closeConn(database);
        }
    }

    private static void testDelete(JDOManager jdoManager) {
        Database database = null;
        OQLQuery oql1 = null;
        OQLQuery oql2 = null;
        try {
            database = jdoManager.getDatabase();
            database.begin();
            oql1 = database.getOQLQuery("DELETE p FROM com.ggd543.demo.jdo.Product p");
            QueryResults qr1 = oql1.execute();
            System.out.println("Delete " + qr1.size() + " product's records");
            oql2 = database.getOQLQuery("DELETE p FROM com.ggd543.demo.jdo.Catalogue p");
            QueryResults qr2 = oql2.execute();
            System.out.println("Delete " + qr2.size() + " catalogue's records");
            database.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            rollback(database);
        } finally {
            closeQuery(oql1);
            closeQuery(oql2);
            closeConn(database);
        }
    }

    private static void rollback(Database database) {
        if (database != null) {
            try {
                database.rollback();
            } catch (TransactionNotInProgressException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }


    private static void closeQuery(Query query) {
        if (query != null) {
            query.close();
        }
    }

    private static void closeConn(Database database) {
        if (database != null) {
            try {
                database.close();
            } catch (PersistenceException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private static void testAdd(JDOManager jdoManager) throws MappingException {
        // load the JDO configuration file and construct a new JDOManager

        Database database = null;
        try {
            // Obtain a new database
            database = jdoManager.getDatabase();
            // Begin a transaction
            database.begin();
            // do something
            Catalogue catalogue = new Catalogue();
            catalogue.setId(567L);
            catalogue.setName("business product");

            Product p1 = new Product(12L, "product 1");
            p1.setCatalogue(catalogue);
            Product p2 = new Product(23L, "product 2");
            p2.setCatalogue(catalogue);
            List<Product> productList = new ArrayList<Product>(2);
            productList.add(p1);
            productList.add(p2);
            catalogue.setProducts(productList);
            database.create(catalogue);

//            System.out.println(database.getIdentity(p1));
//            database.create(p1);
//            System.out.println("product 1 id = " + p1.getId());
//            database.create(p2);
//            System.out.println("product 2 id = "+p2.getId());


            database.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            rollback(database);
        } finally {
            closeConn(database);
        }

    }
}
