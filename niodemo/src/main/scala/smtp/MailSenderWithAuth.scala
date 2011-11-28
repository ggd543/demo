//package smtp
//import java.io.{PrintWriter, BufferedReader, InputStreamReader}
//import java.net.{InetAddress, Socket}
//import sun.misc.BASE64Encoder
//
///**
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 2009-11-5
// * Time: 0:07:53
// * To change this template use File | Settings | File Templates.
// */
//
//class Message(
//        val from: String, //�����ߵ��ʼ���ַ
//        val to: String, //�����ߵ��ʼ���ַ
//        val subject: String, //�ʼ�����
//        val content: String //�ʼ�����
//        ) {
//  val data = "Subject: " + subject + "\r\n" + content;
//}
//
//class MailSenderWithAuth(
//val smtpServer: String
//        ) {
//  val port=25
//  def sendMail(msg: Message) : Unit={
//    val socket=new Socket(smtpServer,port)
//    val br=new BufferedReader(new InputStreamReader(socket.getInputStream))
//    val pw=new PrintWriter(socket.getOutputStream)
//    val localhost=InetAddress.getLocalHost.getHostName
//    var username="ggd543@gmail.com"
//    var password="@$^*)lyj1985"
//    username=new BASE64Encoder().encode(username.getBytes)
//    password=new BASE64Encoder().encode(password.getBytes)
//    sendAndReceive(null,br,pw)
//    sendAndReceive("EHLO "+localhost,br,pw)
//    sendAndReceive("AUTH LOGIN ",br,pw)
//    sendAndReceive(username,br,pw)
//    sendAndReceive(password,br,pw)
//    sendAndReceive("MAIL FROM: "+msg.from,br,pw)
//    sendAndReceive("RCPT TO: "+msg.to,br,pw)
//    sendAndReceive("DATA "+data,br,pw)
//    sendAndReceive(".",br,pw)
//    sendAndReceive("QUIT",br,pw)
//  }
//
//  def sendAndReceive(str: String, br: BufferedReader, pw: PrintWriter):Unit={
//    if (str!=null){
//      println("Client>"+str)
//      pw.println(str)
//      pw.flush
//    }
//    var response: String =null
//    if ((response=br.readLine)!=null){
//      println("Server>"+response)
//    }
//  }
//}
//
//object MailSenderWithAuth {
//  def main(args: Array[String]): Unit = {
//    val smtpServer="smtp.gmail.com"
//    val msg = new Message("ggd543@gmail.com", "yliu@kalengo.com", "Hello", "I want to go home")
//    new MailSenderWithAuth(smtpServer).sendMail(msg)
//  }
//}