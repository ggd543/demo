import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LowLevelUIDemoMIDlet extends MIDlet{
	private ScreenCanvas sc; 
	private ImageCanvas ic;
	
	public LowLevelUIDemoMIDlet() {
		Display display = Display.getDisplay(this);
		Command exitCmd = new Command("Exit" , Command.EXIT,1);
		Command nextCmd = new Command("Next" , Command.SCREEN,1);
		sc = new ScreenCanvas();
		ic = new ImageCanvas();
		sc.addCommand(exitCmd);
		ic.addCommand(exitCmd);
		sc.addCommand(nextCmd);
		ic.addCommand(nextCmd);
		sc.setCommandListener(sc.new ScreenCanvasCommandListener(this, nextCmd, exitCmd, ic));
		ic.setCommandListener(ic.new ImageCanvasCommandListener(this, nextCmd, exitCmd, sc));
		display.setCurrent(sc);
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
	}
}
