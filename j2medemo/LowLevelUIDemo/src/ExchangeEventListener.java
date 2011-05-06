import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public abstract class ExchangeEventListener implements CommandListener{
	protected final  Command nextCmd;
	protected final  Command exitCmd;
	protected final MIDlet midlet;
	
	public ExchangeEventListener(MIDlet midlet, Command nextCmd, Command exitCmd){
		this.midlet = midlet;
		this.nextCmd= nextCmd;
		this.exitCmd = exitCmd;
	}	
	
	public void commandAction(Command c, Displayable d){		
		if (c == nextCmd){	
			Display display = Display.getDisplay(this.midlet);
			display.setCurrent(getDisplayable());
		}else if (c == exitCmd){
			midlet.notifyDestroyed();
		}
	}
	
	abstract protected Displayable getDisplayable();
	
	
}
