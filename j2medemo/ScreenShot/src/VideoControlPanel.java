import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.media.protocol.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import java.io.*;

public class VideoControlPanel extends Form implements CommandListener, PlayerListener{
	private final Command cmdScreenshot = new Command("Screenshot", Command.OK, 1);
	private final Command cmdBack = new Command("Back", Command.BACK, 1);
	
	private final Display display;	
	private final Displayable mainControlPanel;
	
	private Player player;
	private VideoControl videoControl;
	private RecordStore rs;   // may be null	
	private Item videoItem;
	
	public VideoControlPanel(Display display, Displayable mainControlPanel){
		super("");
		this.display = display;		
		this.mainControlPanel =  mainControlPanel;	
		addCommand(cmdBack);
		addCommand(cmdScreenshot);
		setCommandListener(this);		
		showGauge("Opening the camera\n. Pls wait ...");	
		//#debug
		System.out.println("Opening the camera\n. Pls wait ...");
		// Start the Camera
		try{
			player = Manager.createPlayer("capture://video");
			player.addPlayerListener(this);
			player.realize();
			videoControl = (VideoControl)player.getControl("VideoControl");
			if (videoControl != null){
				videoItem = (Item)(videoControl.initDisplayMode(GUIControl.USE_GUI_PRIMITIVE, null));				
				videoControl.setDisplayFullScreen(true);
			}else{
				throw new RuntimeException("Can not retrieve a VideoControl");
			}
			player.start();
		}catch(Exception e){
			Alert alert = new Alert("Error", "Fail to open the camera", null, AlertType.ERROR);
			display.setCurrent(alert, mainControlPanel);
			//#debug
			System.out.println("Fail to open the camera\n"+e);
			return;
		}
		// Open the RecordStore
		try{
			rs = RecordStore.openRecordStore(ScreenshotMIDlet.IMAGE_RECORD_STORE, true);
		}catch(Exception e){
			Alert alert = new Alert("Error", "Fail to open the RecordStore", null, AlertType.WARNING);
			alert.setTimeout(1000);
			display.setCurrent(alert);	
		}		
	}
	
	 public void playerUpdate(Player player, java.lang.String event, java.lang.Object eventData) {
		if (event.equals(PlayerListener.STARTED)){
			try{
				Thread.sleep(2000L);
			}catch(Exception e){
				//#debug
				System.out.println();
			}
			showCameraScreen();		
		}
	 }
	
	private void showGauge(final String msg ){
		Gauge g = new Gauge(msg, false, Gauge.CONTINUOUS_RUNNING, Gauge.INDEFINITE);
		VideoControlPanel.this.deleteAll();
		VideoControlPanel.this.append(g);
	}
	
	private void showCameraScreen(){		
		deleteAll();
		videoControl.setVisible(true);
		append(videoItem);
		//#debug
		System.out.println("showCameraScreen()");
	}
	
	private void hideCameraScreen(){
		deleteAll();
		videoControl.setVisible(false);
		//#debug
		System.out.println("hideCameraScreen()");
	}
	
	
	public void commandAction(Command c, Displayable d){
		if (c == cmdBack ) {
			if (player != null) player.close();
			display.setCurrent(mainControlPanel);
		}else if (c == cmdScreenshot) screenshot();
	}	
	
	private void screenshot(){
		try{			
			hideCameraScreen();
			showGauge("Making a screenshot\n.Pls wait ...");						
			System.out.println("Taking a screenshot");
			byte[] data = videoControl.getSnapshot(null);
			System.out.println("Finish screenshot");
			VideoControlPanel.this.display.setCurrent(new ScreenForm(data));
		}catch(Exception e){
			//#debug
			System.out.println("There was a problem when making a screenshot.\n"+e);
			Alert alert = new Alert("Warning", "There was a problem when making a screenshot", null, AlertType.WARNING);			
			display.setCurrent(alert);
			showCameraScreen();
		}
	}
	
	private class ScreenForm  extends Form implements CommandListener{
		private final byte[] data;
		private final String url = null;
	    private final Command cmdUpload = new Command("Upload", Command.OK, 2);
		private final Command cmdCancel = new Command("Cancel", Command.CANCEL, 1);
		private final Command cmdSave = new Command("Save", Command.OK, 2);
		private final Display display = VideoControlPanel.this.display;
		
		public ScreenForm(byte []data){
			super("Screenshot");
			this.data = data;
			addCommand(cmdCancel);
			addCommand(cmdSave);
			setCommandListener(this); 
			Image image = Image.createImage(data, 0 , data.length);
			append(image);
		}
		
		public void commandAction(Command c, Displayable d){
			if (cmdSave == c ){
				storeImage();		
			}else if (cmdCancel == c){
				showCameraScreen();
				display.setCurrent(VideoControlPanel.this);
			}else if (cmdUpload == c){
				Alert alert = new Alert("Infomation", "The operation doesn't supported currently", null ,AlertType.INFO);
				display.setCurrent(this);
				showCameraScreen();
			}
		}
		
		private void storeImage(){
			if (rs == null) throw new IllegalArgumentException();
			try{
				showGauge("Saving the iamge.\nPls wait ...");
				rs.addRecord(data, 0 , data.length);
				Alert alert = new Alert("Successfully", "Save successfully", null, AlertType.INFO);
				showCameraScreen();
				display.setCurrent(alert, VideoControlPanel.this);
			}catch(RecordStoreException e){
				//#dbug
				System.out.println( "Fail to save the screenshot.\n"+e);
				Alert alert = new Alert("Fail", "Fail to save the screenshot", null , AlertType.WARNING);
				display.setCurrent(alert);
			}
		}	
	}
	
	
}