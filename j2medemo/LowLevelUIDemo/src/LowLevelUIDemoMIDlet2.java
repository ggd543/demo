import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LowLevelUIDemoMIDlet2 extends MIDlet{
	private ImageForm imageForm;
	
	public LowLevelUIDemoMIDlet2() {
		Display display = Display.getDisplay(this);
		Command exitCmd = new Command("Exit" , Command.EXIT,1);			
		imageForm = new ImageForm("ImageForm");		
		imageForm.addCommand(exitCmd);			
		imageForm.setCommandListener(imageForm.new ImageFormCommandListener(this , exitCmd));
		display.setCurrent(imageForm);
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
	}
}
