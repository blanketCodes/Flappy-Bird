import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Tube {

	int x, y, h1, h2;
	int dx;
	
	int width = 80;
	
	int sw = GamePanel.WIDTH;
	int sh = GamePanel.HEIGHT;
	
	//the band is where the bird can pass and according to it i'll draw the tubes:
	
	
	int bandH = 150; // band height
	int bUL; // band upper limit
	int bDL; // band down limit
	
	//for collision detection
	ArrayList<Rectangle> bounds ;
	
	Color color;
	
	public Tube(){
		
		//the band upper limit min is 0 and max is sh - bandh height
		//(Math.random() * ((max - min) + 1)) + min
		bUL = (int)(Math.random()* (300 - 0)) + 0;
		//band down limit is band Upper limit + bandh 
		bDL= bUL + bandH;
		
		//get the heights according to the band space: 
		// height one goes from 0 to where the band is:
		h1 = bUL;
		// height two goes from 0 to where the lower part of the band is;
		h2 = bDL;
		
		
		//h1 = (int)(Math.random()*sh/2) + 50;
		//h2 = (int)(Math.random()*sh/2) + 50;
		
		//initial x position
		x = sw;
		//set the spead of the tubes
		dx = -10;
		//
		bounds = new ArrayList<Rectangle>();
		//
		color = Color.WHITE;
	}
	
	public ArrayList<Rectangle> getBounds(){
		Rectangle rect1 = new Rectangle(x, 0, width, h1);
		Rectangle rect2 = new Rectangle(x, bDL, width, sh - bDL);
		bounds.add(rect1);
		bounds.add(rect2);
		return bounds;
	}
	
	public void changeColor()
	{
		color = Color.RED;
		System.out.println("change color");
	}
	
	
	public void update(){
		x += dx; 
	}
	
	public void draw(Graphics g2d){
		g2d.setColor(color);
		//upper rec:
		g2d.drawRect(x, 0, width, h1);
		// lower rec:
		g2d.drawRect(x, bDL, width, sh - bDL);
		
		//draw the band in red
//		g2d.setColor(Color.RED);
//		g2d.drawLine(0, bUL, sw, bUL);
//		g2d.setColor(Color.BLUE);
//		g2d.drawLine(0, bDL, sw, bDL);

	}
	
	//
	public int getX(){return x;}
	public int getWidth(){return width;}
	
	
}
