import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ImageForm extends Form{
	private final Image image ;
	
	public ImageForm(String title){
		super(title);
		image = Image.createImage(getWidth(), getHeight()); 
		append(image);
		new ImageFormThread().start();
	}
	
	private class ImageFormThread extends Thread{	
		private final String []text = new String[]{"I want to go home", "What a fine day"};
		
		public void run(){
			Graphics g = image.getGraphics();
			int width = ImageForm.this.getWidth();
			int height = ImageForm.this.getHeight();
			Font font = g.getFont();
			int h = font.getHeight();
			int y = 0;
			int i = 0;
			while(true){
				g.drawString(text[i], 0, y, 0);
				ImageForm.this.set(0, new ImageItem(null, image, ImageItem.LAYOUT_DEFAULT, null));
				try{
					System.out.println("Sleep 1 second");
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				y = y + h + 5;
				if (y + h  > height){
					g.setColor(255,255,255);
					g.fillRect(0,0, width, height);
					y = 0;				
					i = (i +1) % text.length;
					g.setColor(0,0,0);
				}
				
			}//while(true)		
		}
	}	
	
	class ImageFormCommandListener extends ExchangeEventListener{
		public ImageFormCommandListener(MIDlet midlet, Command exitCmd){
			super(midlet, null, exitCmd);
		}
		
		public void  commandAction(Command c, Displayable d){
			super.commandAction(c,d);
		}		
		
		public Displayable getDisplayable(){
			return ImageForm.this;
		}		
	}
	
}
