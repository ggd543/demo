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
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

import java.util.Collection;

public class DroolsQueryDemo {
    public static void main(String[] args) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("test/query.drl"), ResourceType.DRL);
        Collection collection = kbuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(collection);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
//        session.insert(new Customer("zhang san"));
        session.insert(new Customer("lisi",23));
        session.insert(new Customer("zhangsan",32));
//        session.insert(new Customer("wang er"));
//        session.insert(new Customer("li xiao long"));
        session.fireAllRules();

        QueryResults qrs = session.getQueryResults("testQuery", 10);
        System.out.println("customer 数目: "+qrs.size());
        for (QueryResultsRow  qrr: qrs){
            Customer customer = (Customer) qrr.get("customer");
            System.out.println("customer name: "+customer.getName()+" "+customer.getAge());
        }
        session.dispose();
        System.out.println("end.");
        // why
    }
}
