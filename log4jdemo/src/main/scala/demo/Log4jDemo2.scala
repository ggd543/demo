package demo

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-1-1
 * Time: 19:39:59
 * To change this template use File | Settings | File Templates.
 */

object Log4jDemo2 {
  def f1 = throw new Exception("Hello world", new Throwable("Unknonw why"))

  def f2 = try {
    f1
  } catch {
    case ex: Exception => throw new Exception(ex.getMessage, ex.getCause)
  }

  def f3 = try {
    f1
  } catch {
    case ex: Exception => throw new Exception("one world, one dream")
  }

  def f4 = try {
    f1
  } catch {
    case ex: Exception => throw new Exception(new Throwable("No news is good news"))
  }

  def f5 = try {
    f1
  } catch {
    case ex: Exception => throw new Exception(new Throwable(ex.getCause))
  }

  def f6 = try {
    f1
  } catch {
    case ex: Exception => throw new Exception("Something strange", ex.getCause)
  }

  def f7 = try {
    f6
  } catch {
    case ex: Exception => throw new Exception(ex.getCause)
  }
  
}