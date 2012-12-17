//package mail
//
//import javax.mail.internet.{InternetAddress, MimeMessage}
//import java.util.{Date, Properties}
//import javax.mail.{Message, Session, Transport}
//import javax.naming.Context
//
//
///**
// *
// * User: 刘永健
// * Date: 12-5-29
// * Time: 上午10:05
// * To change this template use File | Settings | File Templates.
// */
//
//object JavaMailDemo {
//
//  import scala.collection.JavaConversions._
//
//  def main(args: Array[String]): Unit = {
//    val conf = Map("proxySet" -> "true",
//      "socksProxyHost" -> "10.123.74.137", "socksProxyPort" -> "1080",
//      "mail.smtp.host" -> "smtpav.travelsky.com", "mail.smtp.port" -> "25", "mail.transport.protocol" -> "smtp",
//      "mail.pop3.host" -> "pop3.travelsky.com", "mail.pop3.port" -> "110", "mail.store.protocol" -> "pop3",
//      "mail.smtp.auth" -> "false", "mail.debug" -> "true"
//       )
//    val props = new Properties(System.getProperties)
//    props.putAll(conf)
//
//    val session = Session.getDefaultInstance(props);
//    // 需要smtp验证
//    //    val session = Session.getDefaultInstance(props, new Authenticator(){
//    //      override def getPasswordAuthentication = new javax.mail.PasswordAuthentication(props.getProperty("mail.smtp.user"), props.getProperty("mail.smtp.password"))
//    //    })
//    val message = new MimeMessage(session)
//    val fromAddr = new InternetAddress("liuyongjian@travelsky.com")
//    val toAddr = new InternetAddress("liuyongjian@travelsky.com")
//    message.setFrom(fromAddr)
//    message.setRecipient(Message.RecipientType.TO, toAddr)
//    message.setSubject("test")
//    message.setText("测试")
//    message.setSentDate(new Date())
//    Transport.send(message)
//    System.out.println("mail sent")
//
//  }
//}
