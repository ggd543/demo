import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.util.*;
import java.io.*;

public class ContentTextBox extends TextBox{		
	private final Command backCmd = new Command("Previous",Command.BACK, 2);
	private final Command finishCmd = new Command("Finish",Command.OK, 2);
	
	public ContentTextBox(String title){
		super(title,"",1000,TextField.ANY);	
		this.addCommand(backCmd);
		this.addCommand(finishCmd);		
	}
	
	final class ContentTextBoxEventListener extends ActionEventListener{
		private Displayable nextDisplayable;
				
		public ContentTextBoxEventListener(MIDlet midlet , Command exitCmd, Displayable nextDisplayable){
			super(midlet, exitCmd);
			this.nextDisplayable = nextDisplayable;
		}
		
		public void doAction(Command c, Displayable d){
			if (finishCmd == c){
				String title = super.getTitle();
				String content = ContentTextBox.this.getString();
				final String fileName = String.valueOf(System.currentTimeMillis())+".txt";
				final String text = "Title: "+title+"\nContent: "+content;				
				new Thread(){
					public void run(){						
						try{
							IO.write(fileName, text);
							System.out.println("================Here is the file: "+fileName+"=====================");
							System.out.println(IO.read(fileName));	
							System.out.println("===================================================================");
						}catch(IOException e){
							e.printStackTrace();
						}catch(Throwable e){
							e.printStackTrace();
							System.out.println("An error occurred when writing to file: "+fileName);
							ContentTextBoxEventListener.this.midlet.notifyDestroyed();
						}
					}
				}.start();
				ContentTextBox.this.setString("");
			}else if (backCmd == c ){
				ContentTextBox.this.setString("");
			}			
		}
		
		public Displayable getDisplayable(Command c, Displayable d){
			if (c == backCmd || c == finishCmd) return this.nextDisplayable;			
			else return ContentTextBox.this;
		}	
		
	}
	
}
