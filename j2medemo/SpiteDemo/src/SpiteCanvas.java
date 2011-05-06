import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.*;

public class SpiteCanvas extends GameCanvas implements CommandListener{
	private final Command exitCmd = new Command("exit", Command.EXIT, 1);
	private final Command rpl1Cmd = new Command("Reference Pixel 1", Command.OK, 2);
	private final Command rpl2Cmd = new Command("Reference Pixel 2", Command.OK, 2);
	private final MIDlet midlet;
	private Sprite sprite;
	private final int frameWidth = 96;
	private final int frameHeight = 36;
	private SpiteMovingTask task;
	
	public SpiteCanvas(MIDlet midlet){
		super(true);	
		this.midlet = midlet;
		addCommand(rpl1Cmd);
		addCommand(rpl2Cmd);
		addCommand(exitCmd);
		setCommandListener(this);		
		try{
			Image image = Image.createImage("/sprite.PNG");			
			sprite = new Sprite(image, frameWidth, frameHeight);			
		}catch(Exception e){
			System.out.println("Not found sprite.PNG");
			midlet.notifyDestroyed();			
			return;
		}
		task = new SpiteMovingTask();
		new Thread(task).start();	
	}
	
	class SpiteMovingTask implements Runnable{
		private boolean isStop = false;
		
		public synchronized void setStop(boolean isStop){
			this.isStop = isStop;
		}
		
		public synchronized boolean isStop(){
			return isStop;
		}
		
		public void run(){
			sprite.setFrameSequence(new int[]{0,1,2,1, 0,1,2,1, 0,1,2,1, 1,1,1,1,1,1});
			int width = SpiteCanvas.this.getWidth();
			int height = SpiteCanvas.this.getHeight();
			int x = sprite.getRefPixelX();
			int y = sprite.getRefPixelY();
			repaint(width,height);
			
			while(!isStop()){
				int code = SpiteCanvas.this.getKeyStates();
				boolean needRepaint = false;
				if ((code & SpiteCanvas.UP_PRESSED)!= 0 && y -1 >= 0){					
					sprite.move(0, -1);
					y -=1;
					needRepaint = true;
				}
				if ((code & GameCanvas.DOWN_PRESSED) != 0 && y+ 1 + frameHeight <= height){
					y +=1;
					sprite.move(0,1);
					needRepaint =true;
				}
				if ((code & GameCanvas.LEFT_PRESSED) != 0 && x - 1 >= 0){
					x -= 1;
					sprite.move(-1, 0);
					needRepaint =true;
				}
				if ((code & GameCanvas.RIGHT_PRESSED) != 0 && x+1+frameWidth <= width){
					x += 1;
					sprite.move(1, 0);
					needRepaint =true;
				}
				if (needRepaint){
					repaint(width,height);
				}
				
			}
		}
		
		private void repaint(int width, int height){
			Graphics g = SpiteCanvas.this.getGraphics();
			g.setColor(0xFFFFFF);
			g.fillRect(0,0,width,height);
			sprite.paint(g);
			SpiteCanvas.this.flushGraphics();
		}
		
	}
	
	public void commandAction(Command c, Displayable d){
		if (c == exitCmd){		
			task.setStop(true);
			midlet.notifyDestroyed();			
		}else if (c == rpl1Cmd ){			
			task.setStop(true);
			sprite.defineReferencePixel(frameWidth/2 ,frameHeight/2);
			task = new SpiteMovingTask();
			new Thread(task).start();
		}else if (c == rpl2Cmd ){
			task.setStop(true);
			sprite.defineReferencePixel(frameWidth/2 , 0);
			task = new SpiteMovingTask();
			new Thread(task).start();
		}		
	}
	
	
}
