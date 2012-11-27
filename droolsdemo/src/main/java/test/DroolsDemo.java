/* 
 * Date: 12-11-26
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
package test;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import java.util.*;

/**
 * @author 刘永健(http://my.oschina.net/aiguozhe)
 */
public class DroolsDemo {
    public static void main(String[] args) {
        // 创建KnowledgeBuilder加载并编译相关的规则文件,产生对应的KnowledgePackage集合
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("test.drl"), ResourceType.DRL);
        if (kbuilder.hasErrors()) {
            System.out.println("规则中存在错误: ");
            KnowledgeBuilderErrors errors = kbuilder.getErrors();
            Iterator iterator = errors.iterator();
            while (iterator.hasNext()) {
                KnowledgeBuilderError error = (KnowledgeBuilderError) iterator.next();
                System.out.println(error);
            }
        }
        Collection<KnowledgePackage> kpackages = kbuilder.getKnowledgePackages();
        System.out.println(kpackages);
// 通过KnowledgeBase把产生的KnowledgePackage集合收集起来
        KnowledgeBaseConfiguration kbConf = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
        kbConf.setProperty("org.drools.sequential", "true");
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(kbConf);
        kbase.addKnowledgePackages(kpackages); // 将KnowledgePackage集合添加到KnowledgeBase中
// 创建StatefulKnowledgeSession，将规则当中需要使用的fact对象插入进去，将需要用到的global设置进去, 最后调用fireAllRules()方法执行规则
        StatefulKnowledgeSession statefulKSession = kbase.newStatefulKnowledgeSession();
        statefulKSession.setGlobal("globalTest", new Object()); // 设置一个global对象
        statefulKSession.insert(new Object()); // 插入一个fact对象
        statefulKSession.fireAllRules();
        statefulKSession.dispose();  //最终还要调用dispose()方法释放占用的内存

        // StatelessKnowledgeSession是对StatefulKnowledgeSession的封装,
        StatelessKnowledgeSession statelessKSession = kbase.newStatelessKnowledgeSession();
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        statelessKSession.execute(list);
        // 如果需要向execute()传入fact对象和global对象，需要使用Command对象

        List<Command> commandList = new LinkedList<Command>();
        StatelessKnowledgeSession statelessKnowledgeSession = kbase.newStatelessKnowledgeSession();
        commandList.add(CommandFactory.newInsert(new Object()));
        commandList.add(CommandFactory.newInsert(new Object()));
        commandList.add(CommandFactory.newSetGlobal("key1", new Object()));
        commandList.add(CommandFactory.newSetGlobal("key2", new Object()));
        statelessKnowledgeSession.execute(CommandFactory.newBatchExecution(list));
    }
}