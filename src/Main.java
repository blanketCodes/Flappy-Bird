import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.add(new GamePanel());
		frame.setTitle("Flappy Bird");
	    frame.pack();       
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

}
