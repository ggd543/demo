import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public abstract class ActionEventListener implements CommandListener{	
	protected final MIDlet midlet;
	private String title;	
	protected final Command exitCmd;
	
	public ActionEventListener(MIDlet midlet, Command exitCmd){
		this.midlet = midlet;
		this.exitCmd = exitCmd;
	}
	
	public void commandAction(Command c , Displayable d){
		if (c == exitCmd)  {
			System.out.println("Exit normally");
			this.midlet.notifyDestroyed();
		}else{
			Display display = Display.getDisplay(this.midlet);
			display.setCurrent(getDisplayable(c,d));
			doAction(c, d);
		}
	}
	
	public void setTitle(String title){
		this.title =  title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	abstract protected Displayable getDisplayable(Command c, Displayable d);
	
	abstract protected void doAction(Command c , Displayable d);
}
