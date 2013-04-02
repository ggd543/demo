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
import org.drools.runtime.rule.Activation;
import org.drools.runtime.rule.AgendaFilter;

import java.util.Collection;
import java.util.Iterator;

public class DroolsAgendaGroupDemo {
    public static void main(String[] args) {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

        kbuilder.add(ResourceFactory.newClassPathResource("test/agenda_group.drl"), ResourceType.DRL);
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
//        session.fireAllRules();
        AgendaFilter filter = new MyAgendaFilter("rule");
        session.fireAllRules(filter);
        session.dispose();

        // why
    }
}

class MyAgendaFilter implements AgendaFilter {
    private String startName;

    public MyAgendaFilter(String startName) {
        this.startName = startName;
    }

    @Override
    public boolean accept(Activation activation) {
        String ruleName = activation.getRule().getName();
        if (ruleName.startsWith(startName)) {
            return true;
        } else {
            return false;
        }
    }
}