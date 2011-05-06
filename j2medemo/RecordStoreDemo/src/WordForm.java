import javax.microedition.lcdui.*;
import javax.microedition.rms.*;
import javax.microedition.midlet.*;
import java.io.*;

public class WordForm extends Form{
	private final RecordStore rs;	
	private final MIDlet midlet;
	
	private final Command listCmd = new Command("list", Command.OK, 1);	
	private final Command exitCmd = new Command("exit", Command.EXIT, 1);
	private final TextField wordField = new TextField("Enter the text", "", 50, TextField.ANY);
	
	public WordForm(RecordStore rs, MIDlet midlet){
		super("Pls enter a word");		
		System.out.println("WordForm constructed");
		this.rs = rs;
		this.midlet=midlet;
		addCommand(listCmd);
		addCommand(exitCmd);
		setCommandListener(new WordFormCommandListener());
		append(wordField);
		Command saveCmd =  new Command("save", Command.ITEM, 2);
		Command clearCmd = new Command("clear", Command.ITEM, 2);
		wordField.addCommand(saveCmd);
		wordField.addCommand(clearCmd);		
		wordField.setItemCommandListener(new WordFieldCommandListener(saveCmd, clearCmd));		
	}
	
	 private class WordFieldCommandListener implements ItemCommandListener{
		private final Command saveCmd;
		private final Command clearCmd;		
		
		public WordFieldCommandListener(Command saveCmd, Command clearCmd){
			this.saveCmd = saveCmd;
			this.clearCmd = clearCmd;
		}
		
		public void commandAction(Command c, Item item) {
			if (c == saveCmd){
				Alert alert = new Alert(null, null, null, null);
				alert.setTimeout(1000);
				try{
					String word = ((TextField)item).getString();
					if (word == null || word.trim().length() == 0) throw new IllegalArgumentException();
					Word w = new Word(word);
					saveWord(w);
					((TextField)item).setString("");
					alert.setString("Save successfully");
					alert.setType(AlertType.INFO);
				}catch(IOException e){
					alert.setString("Fail to save a word");
					alert.setType(AlertType.WARNING);
				}catch(RecordStoreException e){
					alert.setString("Fail to save a word");
					alert.setType(AlertType.WARNING);
				}catch(IllegalArgumentException e){
					alert.setString("Pls enter a word");
					alert.setType(AlertType.WARNING);
				}	
				Display display = Display.getDisplay(midlet);
				display.setCurrent(alert, WordForm.this);
			}else if (c == clearCmd){
				((TextField)item).setString("");
			}
		}
		
		private void saveWord(Word w) throws IOException, RecordStoreException {
			byte[] buf = w.serialize();
			rs.addRecord(buf, 0, buf.length); 
		}
	}
		
	class WordFormCommandListener implements  CommandListener{
		private final Command backCmd = new Command("back", Command.BACK, 1);
		
		private final RecordFilter rf = new RecordFilter(){
			public boolean matches(byte[] candidate){
				try{
					Word w = Word.deserialize(candidate);
					if (w.comment.trim().length() == 0)  return false;
					else return true;
				}catch(Exception e){
					return false;
				}
			}
		};
		
		public void commandAction(Command c , Displayable d ){
			Display display = Display.getDisplay(midlet);
			if (c == exitCmd){			
				midlet.notifyDestroyed();
			}else if (c == listCmd){				
				try{
					listWords(rf);				
				}catch(Exception e){
					Alert alert = new Alert(null, "Unknown error occurs", null, AlertType.WARNING);
					alert.setTimeout(1000);
					display.setCurrent(alert, WordForm.this);
				}
			}else if (c == backCmd){
				display.setCurrent(WordForm.this);
			}			
		}
		
		private void listWords(RecordFilter rf) throws Exception{
			RecordEnumeration  re = rs.enumerateRecords(rf, new RecordComparator(){
				public int compare(byte[] rec1, byte[] rec2) {
					try{
						Word w1 = Word.deserialize(rec1);
						Word w2 = Word.deserialize(rec2);
						if (w1.word.length() < w2.word.length()) return RecordComparator.PRECEDES;
						else return RecordComparator.FOLLOWS;
					}catch(Exception e){
						return RecordComparator.EQUIVALENT ;
					}
				}				
			},false);
			Form f = new Form("Word List");
			while(re.hasNextElement() ){
				Word w = Word.deserialize(re.nextRecord());
				StringItem si = new StringItem(null, w.word);
				f.append(si);
			}
			f.addCommand(backCmd);
			f.setCommandListener(this);
			Display display = Display.getDisplay(midlet);
			display.setCurrent(f);				
		}		
	}
	
		
	
	
}
