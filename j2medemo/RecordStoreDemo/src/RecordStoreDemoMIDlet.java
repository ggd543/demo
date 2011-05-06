import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.*;

public class RecordStoreDemoMIDlet extends MIDlet{
	private WordForm wf ; 
	private RecordStore rs ;
	
	public RecordStoreDemoMIDlet() {
		System.out.println("RecordStoreDemoMIDlet()");
		Display display = Display.getDisplay(this);		
		try{
			rs= RecordStore.openRecordStore("WordStore", true);			
		}catch(RecordStoreException e){
			notifyDestroyed();
			return;
		}
		wf = new WordForm(rs, this);				
		display.setCurrent(wf);
	}
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		System.out.println("destroyApp("+unconditional+")");
		if (rs != null){
			try{
				rs.closeRecordStore();
			}catch(RecordStoreException e){
				e.printStackTrace();
			}
		}
	}
	
	protected void pauseApp() {
	}
	
	protected void startApp() throws MIDletStateChangeException{
	}
}
