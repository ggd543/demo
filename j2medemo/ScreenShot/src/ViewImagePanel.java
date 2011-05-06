import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.media.protocol.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

public class ViewImagePanel extends Form implements CommandListener{	
	private final Display display;	
	private final Displayable mainControlPanel;
	
	private final Command cmdBack = new Command("Back", Command.BACK, 2);
	private final Command cmdNext = new Command("Next", Command.OK, 3);
	private final Command cmdDel = new Command("Del", Command.OK, 3);
	private final Command cmdPrev = new Command("Previous", Command.OK, 3);		
		
	private RecordStore rs;
	private RecordEnumeration enumeration ;	
	private int recordId;
	
	public ViewImagePanel(Display display, Displayable mainControlPanel){
		super("Your photo");
		this.display = display;
		this.mainControlPanel = mainControlPanel;
		addCommand(cmdBack);		
		setCommandListener(this);
		// Open a RecordStore
		try{
		    rs = RecordStore.openRecordStore(ScreenshotMIDlet.IMAGE_RECORD_STORE, true);
			enumeration = rs.enumerateRecords(null, null, true);
			recordId  = -1;
		}catch(RecordStoreException e){	
			Alert alert = new Alert("Error","Fail to open the RecordStore! ", null, AlertType.ERROR);
			ViewImagePanel.this.display.setCurrent(alert, mainControlPanel);
			return ;
		}
		// Display the number of photo in the RecordStore currently		
		readyDisplayRecords();		
		adjustCommand();
	}
	
	public void commandAction(Command c, Displayable d){
		if (c == cmdBack){
			enumeration.destroy();		
			display.setCurrent(mainControlPanel);
			return;
		}
		byte[] imgBuf = null;
		try{
			if (c == cmdNext){	
				recordId = enumeration.nextRecordId();
				imgBuf = rs.getRecord(recordId);				
				adjustCommand();
			}else if (c == cmdPrev){
				recordId = enumeration.previousRecordId();
				imgBuf =  rs.getRecord(recordId);
				adjustCommand();
			}else if (c == cmdDel){
				rs.deleteRecord(recordId);
				recordId  = -1;
				enumeration.rebuild();
				readyDisplayRecords();
				adjustCommand();
			}
		}catch(Exception e){
			//#debug
			System.out.println("Unknown error while fetching an image.\n"+e);
		}
		if (imgBuf != null){
			// TODO
			Image image = Image.createImage(imgBuf, 0 ,imgBuf.length);
			deleteAll();
			append(image);
		}
	}
	
	private void readyDisplayRecords(){
		int numRecords = enumeration.numRecords();
		switch(numRecords){
			case 0: append(new StringItem(null, "Empty photo")); break;
			case 1: append(new StringItem(null, "There is one photo in the RecordStore")); break;
			default: append(new StringItem(null, "There are "+numRecords+" photo in the RecordStore")); break;
		}
	}
	
	private void adjustCommand(){
		//#debug
		System.out.println("hasNextElement: "+ enumeration.hasNextElement()+ " hasPreviousElement: "+ enumeration.hasPreviousElement());
		if (enumeration == null ) throw new IllegalArgumentException ();
		if (enumeration.hasNextElement())   addCommand(cmdNext);
		else removeCommand(cmdNext);
		if (enumeration.hasPreviousElement()) addCommand(cmdPrev);
		else removeCommand(cmdPrev);
		if (recordId != -1)   addCommand(cmdDel);
		else removeCommand(cmdDel);
	}
	
}
