import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;

public class ImageCanvas extends Canvas{
	private Image image;	
	
	public ImageCanvas(){		
		InputStream is = this.getClass().getResourceAsStream("yihui.png");

		if (is != null){
			try{
			image = Image.createImage(is);
			}catch(Exception e){
				e.printStackTrace();
				image  = Image.createImage(getWidth(), getHeight());				
			}
		}else 
			image = Image.createImage(getWidth(), getHeight());				
		System.out.println("w= "+getWidth()+" h="+getHeight());
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, 0);		
	}	
	
	class ImageCanvasCommandListener extends ExchangeEventListener{
		private Displayable nextDisplayable;
		
		public ImageCanvasCommandListener(MIDlet midlet, Command nextCmd, Command exitCmd, Displayable nextDisplayable){
			super(midlet, nextCmd, exitCmd);
			this.nextDisplayable = nextDisplayable;
		}
		
		public void commandAction(Command c, Displayable d){
			super.commandAction(c,d);
		}
		
		public Displayable getDisplayable(){
			return nextDisplayable;
		}
		
	}
	
}
