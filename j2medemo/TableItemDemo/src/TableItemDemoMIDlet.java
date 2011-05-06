import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

public class TableItemDemoMIDlet extends MIDlet {
    private Form f;
    private Display display;

    public TableItemDemoMIDlet() {
        display = Display.getDisplay(this);
        f = new TableForm("J2ME Polish TableFom", this);
    }

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
    }

    protected void pauseApp() {
    }

    protected void startApp() throws MIDletStateChangeException {
        display.setCurrent(f);
    }
}
