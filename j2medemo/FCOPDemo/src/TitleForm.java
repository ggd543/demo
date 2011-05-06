import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class TitleForm extends Form{
	private final Command nextCmd = new Command("Next", Command.OK, 2);
	
	private final TextField titleField = new TextField("","", 255, TextField.ANY);                                                                                                                                                          
	
	public TitleForm(String title){
		super(title);
		this.append(titleField);		
		this.addCommand(nextCmd);
	}
	
	final class TitleFormEventListener extends ActionEventListener{
		private Displayable nextDisplayable;
		
		public TitleFormEventListener(MIDlet midlet, Command exitCmd, Displayable nextDisplayable){
			super(midlet, exitCmd);
			this.nextDisplayable = nextDisplayable;
		}
		
		public void doAction(Command c , Displayable d){
			if (c == nextCmd){
				setTitle(titleField.getString());
				titleField.setString("");
			}
		}
		
		public Displayable getDisplayable(Command c, Displayable d){
			if (nextCmd == c) return this.nextDisplayable;
			else return TitleForm.this;
		}
	}	
	
}
