package socket

import java.io.IOException
import java.net.ServerSocket

/**
 * Created by 刘永健
 * User: 刘永健
 * Date: 11-11-4
 * Time: 上午11:26
 * To change this template use File | Settings | File Templates.
 */

object PortScan {
  def main(args: Array[String]): Unit = {
    for (port <- 1 to 65535) {
      try {
        val serverSocket = new ServerSocket(port);
        serverSocket.close(); //及时关闭ServerSocket
      } catch {
        case e: IOException => println("端口" + port + " 已经被其他服务器进程占用");
      }
    }
  }

}