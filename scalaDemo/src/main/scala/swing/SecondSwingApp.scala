package swing

import scala.swing._


/**
 *
 * User: 刘永健
 * Date: 12-2-12
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */

object SecondSwingApp extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "Second Swing App"
    val button = new Button {
      text = "Click me"
    }
    val label = new Label {
      text = "No Button clicks registereds"
    }
    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(0, 0, 10, 30)
    }
  }
}
