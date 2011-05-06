import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.media.protocol.*;

public class DumpForm extends Form implements PlayerListener{
	private Player player;
	private VideoControl videoControl;
	private Item videoItem;
	
	public DumpForm(){
		super("");
		Gauge g = new Gauge("Opening the camera.\nPls wait ...", false, Gauge.CONTINUOUS_RUNNING , Gauge.INDEFINITE);
		deleteAll();
		append(g);
			
		try{
			player = Manager.createPlayer("capture://video");			
			player.addPlayerListener(this);
			player.realize();
			videoControl = (VideoControl)player.getControl("VideoControl");
			if (videoControl != null){
				videoItem = (Item)(videoControl.initDisplayMode(GUIControl.USE_GUI_PRIMITIVE, null));				
				videoControl.setDisplayFullScreen(true);
			}else {
				throw new RuntimeException();
			}
			System.out.println("Ready to start the camera");
			player.start();
		}catch(Exception e){
			//#debug
			System.out.println("Fail to open camera.\n"+e);
			deleteAll();
			append("Fail to open camera");			
		}
		
	}
	
	public void playerUpdate(Player player, java.lang.String event, java.lang.Object eventData) {
		if (event.equals(STARTED)) {
			try{
				Thread.sleep(3000L);
			}catch(Exception e){
				//#debug
				System.out.println(e);
			}
			System.out.println("Camera has been started");
			deleteAll();
			append(videoItem);
			videoControl.setVisible(true);			
		}
	}
	
}

	