/* 
 * Date: 12-11-26
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
package test;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.util.*;

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)
 */
public class DroolsMetaDataDemo {
    public static void main(String[] args) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
            System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

            kbuilder.add(ResourceFactory.newClassPathResource("test/fact.drl"), ResourceType.DRL);
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
            FactType factType = knowledgeBase.getFactType("test", "User");

            try {
                Object obj = factType.newInstance();
                session.insert(obj);
            } catch (InstantiationException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            session.fireAllRules();
            session.dispose();
    }
}