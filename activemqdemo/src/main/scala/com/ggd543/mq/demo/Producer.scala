package com.ggd543.mq.demo

/**
 *
 * 功能描述：
 * <p> 版权所有：优视科技
 * <p> 未经本公司许可，不得以任何方式复制或使用本程序任何部分 <p>
 *
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0 
 *        create on: 2014年01月10
 */
import javax.jms._
import org.apache.activemq.ActiveMQConnection
import org.apache.activemq.ActiveMQConnectionFactory

object Producer {
  val activeMqUrl  = ActiveMQConnection.DEFAULT_BROKER_URL
  val topicName  = "TOPIC_NAME"

  def main(args: Array[String]): Unit = {
    val connectionFactory  = new ActiveMQConnectionFactory(activeMqUrl)
    val connection  = connectionFactory.createConnection
    val session  = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    val destination  = session.createTopic(topicName)
    val messageProducer  = session.createProducer(destination)
    messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT)
    messageProducer.setTimeToLive(5000)
    connection.start
    val textMessage  = session.createTextMessage("Hello Subscriber!")
    for (i <- 0 until 3) {
      messageProducer.send(textMessage)
      println("Message sent to subscriber: '" + textMessage.getText + "'")
    }
    connection.close
  }

}
