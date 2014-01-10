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

object DurableSubscriber {
  val activeMqUrl: String = ActiveMQConnection.DEFAULT_BROKER_URL
  val topicName: String = "TOPIC_NAME"

  def main(args: Array[String]): Unit = {
    // Set up the connection, same as the producer, however you also need to set a
    // unique ClientID which ActiveMQ uses to identify the durable subscriber
    val connectionFactory = new ActiveMQConnectionFactory(activeMqUrl)
    val connection = connectionFactory.createConnection
    connection.setClientID("SomeClientID")
    connection.start

    // We don't want to use AUTO_ACKNOWLEDGE, instead we want to ensure the subscriber has successfully
    // processed the message before telling ActiveMQ to remove it, so we will use CLIENT_ACKNOWLEDGE
    val session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE)

    // Register to be notified of all messages on the topic
    val topic = session.createTopic(topicName)
    val durableSubscriber = session.createDurableSubscriber(topic, "Test_Durable_Subscriber")

    // Create a listener to process each received message
    val listener = new MessageListener {
      def onMessage(message: Message): Unit = {
        try {
          if (message.isInstanceOf[TextMessage]) {
            val textMessage: TextMessage = message.asInstanceOf[TextMessage]
            println("Message received from producer: '" + textMessage.getText + "'")

            // Once we have successfully processed the message, send an acknowledge back to ActiveMQ
            message.acknowledge
          }
        } catch {
          case je: JMSException => {
            println(je.getMessage)
          }
        }
      }
    }

    // Add the message listener to the durable subscriber
    durableSubscriber.setMessageListener(listener)
  }

}