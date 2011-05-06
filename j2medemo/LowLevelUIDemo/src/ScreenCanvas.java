import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ScreenCanvas extends Canvas {
	private Command fullScreenCmd = new Command("Full Screen", Command.SCREEN, 1);
	private Command normalCmd = new Command("Normal Screen", Command.SCREEN, 1);
	
	public ScreenCanvas(){
		setTitle("È«ÆÁÄ»²âÊÔ");
		// setTicker(new Ticker("ticker for test"));
		addCommand(fullScreenCmd);
		addCommand(normalCmd);		
	}
	
	public void paint(Graphics g){
		g.setColor(125,125,125); //»ÒÉ«
 		g.fillRect(0,0,getWidth(), getHeight()); // È«ÆÁ
		g.setColor(0,0,0);// ºÚÉ«
		g.drawLine(10,10,150,10);
	}
		
	
	public  void sizeChanged(int w, int h){
		System.out.println("width="+w+" height="+h);
	}
	
	public  void showNotify(){
		System.out.println("showNotify()");
	}
	
	public void hideNotify(){
		System.out.println("hideNotify()");
	}
	
	class ScreenCanvasCommandListener extends ExchangeEventListener{		
		private Displayable nextDisplayable;
		
		public ScreenCanvasCommandListener(MIDlet midlet, Command nextCmd, Command exitCmd, Displayable nextDisplayable){
			super(midlet,nextCmd, exitCmd);			
			this.nextDisplayable=nextDisplayable;
		}
		
		public void commandAction(Command c , Displayable d){
			if (c == fullScreenCmd) {
				System.out.println("Full Screen ");
				setFullScreenMode(true);
			}else if (c == normalCmd ){
				System.out.println("Normal Screen ");
				setFullScreenMode(false);
			}else{
				super.commandAction(c, d);
			}
		}
		
		public Displayable getDisplayable(){
			return nextDisplayable;
		}
		
	}
	
}
