package pool

import actors.Actor
import java.net.ServerSocket
import org.junit.{Assert, After, Before, Test}
import java.io.{DataOutputStream, DataInputStream}

/**
 * Created by 刘永健
 * User: 刘永健
 * Date: 11-11-4
 * Time: 下午6:19
 * To change this template use File | Settings | File Templates.
 */

class SocketPoolTest {
  private val serverPort = 50000
  private var socketPool: SocketPool = null
  private var echoServer: StringEchoSocketServer = null

  @Before
  def setUp() {
    socketPool = new SocketPool(new SocketPool.Config {
      port = serverPort
      maxActive = 8
      maxIdle = maxActive / 2
      minIdle = maxActive / 2
    })
    echoServer = new StringEchoSocketServer(serverPort)
    echoServer.start()
  }

  @After
  def tearDown() {
    socketPool.close()
    echoServer.stop()
  }

  @Test
  def testSocketPoolBehavior() {
    val socket = socketPool.obtainSocket()
    Assert.assertEquals(1, socketPool.numActive)
    val is = new DataInputStream(socket.getInputStream)
    val os = new DataOutputStream(socket.getOutputStream)
    os.writeUTF("hello")
    is.readUTF()
    socketPool.returnSocket(socket)
    Assert.assertEquals(0, socketPool.numActive)
    Assert.assertEquals(1, socketPool.numIdle)
    socketPool.clear()
    Assert.assertEquals(0, socketPool.numIdle)
  }
}

class StringEchoSocketServer(val port: Int) extends Actor {
  private var isStop = false

  def stop() = isStop = true

  def act() {
    val serverSocket = new ServerSocket(port)
    loopWhile(!isStop) {
      val socket = serverSocket.accept()
      Actor.actor {
        println("Create " + socket)
        try {
          val is = new DataInputStream(socket.getInputStream)
          val os = new DataOutputStream(socket.getOutputStream)
          while (true)
            os.writeUTF(is.readUTF())
          println("close " + socket)
        } catch {
          case e =>
            println(socket + " close")
            socket.close()
        }
      }
    }
  }

}

