package objects


/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-6-28
 * Time: 6:54:17
 * To change this template use File | Settings | File Templates.
 */

object FrequencyMain {
  def main(args: Array[String]): Unit = {
    new MyThread().start()
    new MyThread().start()
  }
}

class MyThread extends Thread {
  override def run() {
    Frequency.getClass
  }
}

object Frequency {
  println("Initialzie Frequency")
  Thread.sleep(10000L)
  println("Initialzation complete")
}
