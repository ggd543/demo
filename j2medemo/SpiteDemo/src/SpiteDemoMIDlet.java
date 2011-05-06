import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class SpiteDemoMIDlet extends MIDlet{
	public SpiteDemoMIDlet() {
		Display display = Display.getDisplay(this);		
		display.setCurrent(new SpiteCanvas(this));
	}
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
	}
}
