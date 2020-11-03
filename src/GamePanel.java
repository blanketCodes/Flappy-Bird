import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;


import javax.swing.JPanel;


public class GamePanel  extends JPanel implements ActionListener{

	//global width and height: 
	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;

	//entities:
	Bird bird; 
	ArrayList<Tube> tubes; 
	
	//
	Timer timer;
	
	//timing tubes:
	long startTime;
	long now; 
	

	public GamePanel(){
		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		addKeyListener(new TAdapter());

		timer = new Timer(100, this);
		timer.start();

		bird = new Bird();
		tubes = new ArrayList<Tube>();
		tubes.add(new Tube());
		
		startTime = System.nanoTime();
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//draw bird: 
		bird.draw(g2d);
		
		//draw tubes: 
		for (int i = 0; i < tubes.size(); i++) {
			tubes.get(i).draw(g2d);
		}
		
	}
	
	public void checkCollisions(){
		
		
		Rectangle birdR = bird.getBounds();
		for (int i = 0; i < tubes.size(); i++) {
			ArrayList<Rectangle> tubeR = tubes.get(i).getBounds();
			if(birdR.intersects(tubeR.get(0)))
			{
				System.out.println("hit");
				tubes.get(i).changeColor();
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
		// update bird:
		bird.update();
		
		//update tubes:
		for (int i = 0; i < tubes.size(); i++) {
			tubes.get(i).update();
			if(tubes.get(i).getX() <= 0 - tubes.get(i).getWidth())
			{
				tubes.remove(i);
			}
		}
		
		//check collisions:
		checkCollisions();
		
		// add a tube each interval of time of time: 
		now = System.nanoTime();
		long duration = (now - startTime) /1000000; //devivde by million to change from nano to milli
		if(duration >= 3000)
		{
			tubes.add(new Tube());
			startTime = System.nanoTime();;
		}
		
		repaint();
		
	}	


	
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			bird.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			bird.keyPressed(e);
		}
	}

}
