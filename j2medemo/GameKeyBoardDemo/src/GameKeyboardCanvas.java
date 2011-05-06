import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class GameKeyboardCanvas extends GameCanvas implements Runnable {	
	public GameKeyboardCanvas(){
		super(true);	
		new Thread(this).start();		
	}
	
	public void run(){
		try{
		while(true){
			Thread.sleep(3000);
			int keycode = getKeyStates();
			if ((keycode & DOWN_PRESSED) != 0)   System.out.println("key down");			
			if ((keycode & UP_PRESSED) != 0 )    System.out.println("key up");
			System.out.println("");
		}
		}catch(Exception e){
			
		}
		
	}	
	
	public void paint(Graphics g){
		super.paint(g);
		System.out.println("paint(graphics g)");
	}	
}
