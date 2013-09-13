package cossa.jeffjason.quara;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuScreen extends ScreenState {

	JButton playButton;
	JLabel label;
	JPanel menubuttons;
	
	public MenuScreen(QuaraContainer app) {
		super(app);
		label = new JLabel("Welcome to Quara, press play to play.");
		app.setLayout(new BorderLayout());
		menubuttons = new JPanel(new GridLayout(2,2));
		playButton = new JButton("Play");
		playButton.addActionListener(new PlayAction(app));
		menubuttons.add(label);
		menubuttons.add(playButton);
		app.add(menubuttons,BorderLayout.NORTH);
	}
	
	@Override
	public void update(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
}

class PlayAction implements ActionListener{
	QuaraContainer app;
	JTextField field;
	public PlayAction(QuaraContainer app) {
		this.app = app;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("PLAYING!");
		app.removeAll();
		app.changeScreen(new GameScreen(app));
	}
}
