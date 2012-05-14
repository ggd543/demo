package swing

import scala.swing.{Button, MainFrame, SimpleGUIApplication}


/**
 *
 * User: 刘永健
 * Date: 12-2-12
 * Time: 上午9:22
 * To change this template use File | Settings | File Templates.
 */

object FirstSwingApp extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}
