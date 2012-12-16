/**
 * Created with IntelliJ IDEA.
 * User: 刘永健
 * Date: 12-12-16
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
package test;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.Collection;
import java.util.Iterator;

public class DroolsFactDemo {
    public static void main(String[] args) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

        kbuilder.add(ResourceFactory.newClassPathResource("fact.drl"), ResourceType.DRL);
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
        //        session.getAgenda().getAgendaGroup("002").setFocus();
        // 获取规则文件中定义的Address类型并实例化
        FactType factType = knowledgeBase.getFactType("test", "Address");
        try {
            Object obj = factType.newInstance();
            factType.set(obj, "city", "Shanghai");
            factType.set(obj, "addressName", "Huangpu District");
            session.insert(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        session.fireAllRules();
        session.dispose();

        // why
    }
}
