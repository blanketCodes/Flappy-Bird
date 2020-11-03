import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Bird {
	
	private int x;
	private int y;
	private int dy;
	private int size = 20;
	
	int jumpForce= 50;
	int gravity = (int)Math.floor(jumpForce * 0.1);
	
	
	
	public Bird(){
		x = 200;
		y = GamePanel.HEIGHT -size;
	}
	
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, size, size);
	}
	
	
	public void update(){
					
		y += dy + gravity; 
		
		//out of screen check
		if(y < 0) y = 0;
		if(y > GamePanel.HEIGHT -size) y = GamePanel.HEIGHT - size;
	}
	
	public void draw (Graphics g2d){
		g2d.setColor(Color.WHITE);
		g2d.fillRect(x, y, size, size);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) 
		{
			dy = -jumpForce ;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) 
		{
			dy = 0;
		}
	}


	
}
