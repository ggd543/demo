import javax.microedition.midlet._;
import javax.microedition.lcdui._;

class HiMIDlet extends MIDlet with CommandListener {

    private val exitCommand = new Command("Exit", Command.EXIT, 0) // The exit command
    private val display = Display.getDisplay(this);     // The display for this MIDlet

    override def startApp() {
        val t = new TextBox("Hello", "Hello, World!", 256, 0);
        t.addCommand(exitCommand);
        t.setCommandListener(this);
        display.setCurrent(t);
    }

    override def pauseApp() {
    }

    override  def  destroyApp(unconditional: Boolean) {
    }

    override  def commandAction( c: Command,  s: Displayable) {
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        } 
    }
}