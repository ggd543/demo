package swing

import scala.swing._
import event.ButtonClicked


/**
 *
 * User: 刘永健
 * Date: 12-2-12
 * Time: 下午12:13
 * To change this template use File | Settings | File Templates.
 */

object ReceiveSwingApp extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "Reactive Swing App"
    val button = new Button {
      text = "Click me"
    }
    val label = new Label {
      text = "No button clicks registered"
    }
    contents = new BoxPanel(Orientation.Vertical) {
      contents += button
      contents += label
      border = Swing.EmptyBorder(30, 30, 10, 30)
    }
    listenTo(button)
    var nClicks = 0
    reactions += {
      case ButtonClicked(b) => nClicks += 1
      label.text = "Number of button clicks: " + nClicks
    }
  }

}
