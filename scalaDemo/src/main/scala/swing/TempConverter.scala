package swing

import scala.swing._
import event.EditDone


/**
 *
 * User: 刘永健
 * Date: 12-2-12
 * Time: 下午1:40
 * To change this template use File | Settings | File Templates.
 */

object TempConverter extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "Celsius/Fahrenheit Converter"

    object celsius extends TextField {
      columns = 5
    }

    object fahrenheit extends TextField {
      columns = 5
    }

    contents = new FlowPanel {
      contents += celsius
      contents += new Label(" Celsius = ")
      contents += fahrenheit
      contents == new Label(" Fahrenheit ")
      border = Swing.EmptyBorder(15, 10, 10, 10)
    }
    listenTo(celsius, fahrenheit)
    reactions += {
      case EditDone(`fahrenheit`) =>
        val f = fahrenheit.text.toInt
        val c = (f - 32) * 5 / 9
        celsius.text = c.toString
      case EditDone(`celsius`) =>
        val c = celsius.text.toInt
        val f = c * 9 / 5 + 32
        fahrenheit.text = f.toString
    }
  }
}
