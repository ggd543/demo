/*
 * @(#) EmployApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-02
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package sample

import org.drools.logger.KnowledgeRuntimeLoggerFactory
import org.drools.{KnowledgeBaseConfiguration, KnowledgeBaseFactory, KnowledgeBase}
import org.drools.builder.{ResourceType, KnowledgeBuilderFactory}
import org.drools.io.ResourceFactory

object EmployApp {

  import scala.collection.JavaConversions._

  private def crateEmploy(): Employ = {
    val emp = new Employ();
    emp.setEduInfo("master");
    emp.setResume("tech");
    emp.setAnnualExam("good");
    emp.setAwardPunish("award");
    return emp
  }

  def main(args: Array[String]): Unit = {

    // load up the knowledge base
    val kbase = readKnowledgeBase();
    val ksession = kbase.newStatefulKnowledgeSession();

    val logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

    // go !
    val emp = crateEmploy()
    ksession.insert(emp);
    ksession.startProcess("sample.salary");
    ksession.fireAllRules();

    println("Basic Salary: " + emp.getBasicSalary())
    println("Duty Salary: " + emp.getDutySalary())
    println("Bonus : " + emp.getBonus())
    println("rate : " + emp.getPercent())
    println("Total Salary: %.0f", emp.getTotalSalary())

    logger.close();
  }


  private def readKnowledgeBase(): KnowledgeBase = {
    val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    kbuilder.add(ResourceFactory.newClassPathResource("sample/EduInfo.drl"), ResourceType.DRL);
    kbuilder.add(ResourceFactory.newClassPathResource("sample/Resume.drl"), ResourceType.DRL);
    kbuilder.add(ResourceFactory.newClassPathResource("sample/Bonus.drl"), ResourceType.DRL);
    kbuilder.add(ResourceFactory.newClassPathResource("sample/AwardPunish.drl"), ResourceType.DRL);
    kbuilder.add(ResourceFactory.newClassPathResource("sample/Total.drl"), ResourceType.DRL);
    kbuilder.add(ResourceFactory.newClassPathResource("sample/salary.rf"), ResourceType.DRF);

    val errors = kbuilder.getErrors();

    if (errors.size() > 0) {
      errors.foreach {
        err =>
          System.err.println(err);
      }
      throw new IllegalArgumentException("Could not parse knowledge.");
    }



    val kbConf: KnowledgeBaseConfiguration = KnowledgeBaseFactory.newKnowledgeBaseConfiguration
    println(kbConf.getProperty("org.drools.sequential"))
    kbConf.setProperty("org.drools.sequential", "false")
    val kbase = KnowledgeBaseFactory.newKnowledgeBase(kbConf);
    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
    return kbase;
  }


}
