import javax.microedition.midlet.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.media.protocol.*;
import javax.microedition.lcdui.*;

public class ScreenshotMIDlet extends MIDlet{
	public static String IMAGE_RECORD_STORE = "IMAGE_RECORD_STORE";
	
	private final Command cmdExit = new Command("Exit", Command.EXIT, 1); 
	private final Display display = Display.getDisplay(this);	
	
	public ScreenshotMIDlet() {
		System.out.println(System.getProperty("supports.video.capture"));
		System.out.println(System.getProperty("video.snapshot.encodings"));	
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {		
	}
	
	protected void pauseApp() {
	}
	
	protected void startApp() throws MIDletStateChangeException{
		String videoCaptureSupported = System.getProperty("supports.video.capture");
		if (videoCaptureSupported.equalsIgnoreCase("true")){	
			MainControlPanel mainControlPanel = new MainControlPanel();
			display.setCurrent(mainControlPanel);
		}else{
			display.setCurrent(new VideoCaptureAlert());
		}
	}
	
	class VideoCaptureAlert extends Alert implements CommandListener{			
		public VideoCaptureAlert(){
			super("");
			setString("Your mobile phone doesn't support video capture. Or there is a problem with your camera.");
			addCommand(cmdExit);
			setCommandListener(this);
			setTimeout(Alert.FOREVER);
		}
		public void commandAction(Command c, Displayable d){
			if (c == cmdExit) ScreenshotMIDlet.this.notifyDestroyed();
		}
	}
	
	class  MainControlPanel extends List implements CommandListener{
		private final Display display = ScreenshotMIDlet.this.display;
		private final Command cmdOk = new Command("Ok", Command.OK, 1);
		private VideoControlPanel videoControlPanel;
		private ViewImagePanel  viewImagePanel;		
		
		public MainControlPanel(){		
			super("", IMPLICIT);
			append("Open the camera", null);							
			append("View my photo", null);
			addCommand(cmdExit);
			addCommand(cmdOk);
			setCommandListener(this);	
		}	
		
		public void commandAction(Command c, Displayable d){
			if (c == cmdExit)  ScreenshotMIDlet.this.notifyDestroyed();
			else if (c == cmdOk){
				int index = ((List)d).getSelectedIndex();
				switch(index){
					case 0: display.setCurrent(new VideoControlPanel(display, this)); break;
					case 1: display.setCurrent(new ViewImagePanel(display, this)); break;
					default: break;
				}
			}
		}
	}
	
		
}

	
	
