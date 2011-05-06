import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

import de.enough.polish.util.Locale;

public class MenuBarMIDlet extends MIDlet implements CommandListener{
	private Display display = Display.getDisplay(this);
	private Command cmdExit = new Command("Exit", Command.EXIT, 1);
	private Command cmdOk = new Command("OK", Command.OK, 2);
	private Command cmdDoIt = new Command("Do it", Command.OK, 2);
	private List mainScreen;	
	
	private String getString(){
		if (3 > 2) {
			return "good";
		}else {
			return "fuck";
		}		
	} 
	
	public MenuBarMIDlet() {
		System.out.println("lANGUAGE: "+Locale.LANGUAGE+" COUNTRY: "+Locale.COUNTRY);
		System.out.println(getClass().getResourceAsStream("/image/yihui.png" ));
		System.out.println("Hello: "+Locale.get("Hello"));
		String msg = getString();
		System.out.println(Locale.get("Msg", msg));
		String[] params= new String[2];
		params[0]=msg;
		params[1]=msg;
		System.out.println(Locale.get("Multi-Msg", params));
		
		//#ifdef polish.isVirtual
			System.out.println("polish.isVirtual");
		//#else
			System.out.println("not virtual");
		//#endif
		//#ifdef title:defined
			//#= String title = "${ title }";
		//#else
			String title = "J2ME Polish MenuBar";
		//#endif		
		//#style myStyle
		this.mainScreen = new List(title, List.IMPLICIT);
		this.mainScreen.addCommand(cmdExit);
		this.mainScreen.addCommand(cmdOk);
		this.mainScreen.addCommand(cmdDoIt);
		this.mainScreen.setCommandListener(this);
	}
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{		
		display.setCurrent(mainScreen);
	}
	
	public void commandAction(Command c, Displayable d){
		if (c == cmdExit) this.notifyDestroyed();
	}	
}
