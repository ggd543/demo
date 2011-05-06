import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import msg.*;

public class HelloMIDlet extends MIDlet implements CommandListener {

    private Command exitCommand; // The exit command
    private Display display;     // The display for this MIDlet
  //   private Msg msg = new Msg();
	
    public HelloMIDlet() {
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.EXIT, 0);
    }

    public void startApp() {
		System.out.println("startApp() ...");
        TextBox t = new TextBox("Hello", "Hello, World!", 256, 0);

        t.addCommand(exitCommand);
        t.setCommandListener(this);

        display.setCurrent(t);
    }

    public void pauseApp() {
		System.out.println("pauseApp() ...");
    }

    public void destroyApp(boolean unconditional) {
		System.out.println("destropApp ...");
    }

    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        } 
    }

}
