
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class PDAFileMIDlet extends MIDlet{
	private final TitleForm titleForm ;
	private final ContentTextBox contentTextBox ;
	
	public PDAFileMIDlet() {		
		this.titleForm = new TitleForm("Please enter fileName: ");
		this.contentTextBox = new ContentTextBox("Write something here: ");
        Command exitCmd = new Command("Exit", Command.EXIT , 1);
		titleForm.addCommand(exitCmd);
		contentTextBox.addCommand(exitCmd);
		titleForm.setCommandListener(titleForm.new TitleFormEventListener(this, exitCmd, contentTextBox));
		contentTextBox.setCommandListener(contentTextBox.new ContentTextBoxEventListener(this, exitCmd, titleForm));
		Display.getDisplay(this).setCurrent(this.titleForm);
	}	
	
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
		System.out.println("destroyApp("+unconditional+")");
	}

	protected void pauseApp() {
		System.out.println("pauseApp()");
	}

	protected void startApp() throws MIDletStateChangeException {
		System.out.println("startApp()");
		String v = System.getProperty("microedition.io.file.FileConnection.version" );		
		if ( v == null){
		    System.out.println("Your device doesn't support FCOP");
			this.notifyDestroyed();
		}else{
			try{
				 System.out.println(IO.read("aa.txt"));
			 	//IO.write("aa.txt","222222222222222222222222222222222");
			}catch(Exception e){
				e.printStackTrace();
			}			
			System.out.println("microedition.io.file.FileConnection.version: "+v);
		}
	}

}
