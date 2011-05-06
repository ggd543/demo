import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;

public class ImageChangingCanvas extends Canvas{
	private final Image image[];
	private int i = 0;
	private final Thread thread; 
	
	public ImageChangingCanvas() throws IOException{
		image = new Image[2];
		image[0] = Image.createImage("/yihui.png");
		image[1] = Image.createImage("/hadisi.png");
		thread = new ImageChangingThread();
		thread.start();
	}
	
	public void paint(Graphics g){
		System.out.println(Thread.currentThread());
		g.drawImage(image[i], 0,0, 0);
		//try{		Thread.sleep(3000);		}catch(Exception e)		{		}
		i = (i +1) % image.length;
	}	
	
	class ImageChangingThread extends Thread{		
		public void run(){
			try{
				while(true){
					System.out.println("repaint "+Thread.currentThread());
					ImageChangingCanvas.this.repaint();				
					Thread.sleep(100);	
				}
			}catch(Exception e){
				// do nothing
			}
		}		
	}	

	class ImageChangingCanvasCommandListener extends ExchangeEventListener{		
		public ImageChangingCanvasCommandListener(MIDlet midlet, Command exitCmd){
			super(midlet, null, exitCmd);
		}
		public void commandAction(Command c , Displayable d){
			if (c == exitCmd)   ImageChangingCanvas.this.thread.interrupt();
			super.commandAction(c,d);
		}
		public Displayable getDisplayable(){
			return ImageChangingCanvas.this;			
		}
	}
	

}