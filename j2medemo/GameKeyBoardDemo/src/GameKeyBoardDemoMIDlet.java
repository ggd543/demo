import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class GameKeyBoardDemoMIDlet extends MIDlet{
	
	public GameKeyBoardDemoMIDlet() {
		Display display = Display.getDisplay(this);		
		display.setCurrent(new GameKeyboardCanvas());
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
	}
}
