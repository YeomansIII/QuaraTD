package cossa.jeffjason.quara;

import javax.swing.JFrame;

public class QuaraRunner {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quara Tower Defense");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 frame.setContentPane(new QuaraContainer());
		 frame.setSize(800, 575);
		 frame.setVisible(true);
	}
	
	/* @Override
		public void init() {
		this.setSize(800,575);
		this.setVisible(true);
		this.add(new QuaraContainer());
		this.setVisible(true);
		} */
}
