import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class LowLevelUIDemoMIDlet3 extends MIDlet{
	private ImageChangingCanvas imageChangingCanvas;
	
	public LowLevelUIDemoMIDlet3() {
		Display display = Display.getDisplay(this);
		Command exitCmd = new Command("Exit" , Command.EXIT,1);				
		try{
			imageChangingCanvas = new ImageChangingCanvas();		
		}catch(Exception e){
			notifyDestroyed();
		}		
		imageChangingCanvas.addCommand(exitCmd);			
		imageChangingCanvas.setCommandListener(imageChangingCanvas.new ImageChangingCanvasCommandListener(this , exitCmd));
		display.setCurrent(imageChangingCanvas);
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
	}
}
