import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HighLevelUIDemoMIDlet extends MIDlet{
	private final Display display = Display.getDisplay(this);
	
	public HighLevelUIDemoMIDlet() {		
	}
	protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
	}
	protected void pauseApp() {
	}
	protected void startApp() throws MIDletStateChangeException{
		display.setCurrent(new ControlPanel());
	}
	
	class ControlPanel extends Form implements CommandListener, ItemCommandListener{
		private Command cmdExit = new Command("Exit", Command.EXIT, 1);
		private Command cmdOk = new Command("OK", Command.OK, 1);
		
		public ControlPanel(){
			super("Control Panel");
			ChoiceGroup cg = new ChoiceGroup("Choices", ChoiceGroup.EXCLUSIVE);
			cg.append("Open the camera", null);
			cg.append("View my photo", null);
			cg.append("DumpForm", null);
			append(cg);
			cg.addCommand(cmdOk);
			cg.setItemCommandListener(this);
			addCommand(cmdExit);
			setCommandListener(this);
		}
		
		public void commandAction(Command c, Displayable d){
			System.out.println("commandAction(Command c, Displayable d)");
			if (c == cmdExit)  HighLevelUIDemoMIDlet.this.notifyDestroyed();
		}
		
		public void commandAction(Command c, Item d){
			System.out.println("commandAction(Command c, Displayable d)");			
			if (c == cmdOk) {
				Alert alert = new Alert(null);
				int index = ((ChoiceGroup)d).getSelectedIndex();
				switch(index){
					case 0: alert.setString("Open the camera"); break;
					case 1: alert.setString("View my photo"); break;
					case 2: HighLevelUIDemoMIDlet.this.display.setCurrent(new DumpForm()); return;
					default: alert.setString("Nothing");			   
				}
				HighLevelUIDemoMIDlet.this.display.setCurrent(alert);
			}
		}
	}
	
}
