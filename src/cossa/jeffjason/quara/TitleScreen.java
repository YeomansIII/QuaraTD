package cossa.jeffjason.quara;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class TitleScreen extends ScreenState implements ActionListener{

	Timer time;
	Image title;
	
	public TitleScreen(QuaraContainer app) {
		super(app);
		title = Toolkit.getDefaultToolkit().getImage(getClass().getResource("data/title.png"));
		System.out.println("Constructor complette");
		time = new Timer(10000,this);
		time.start();
	}

	@Override
	public void update(Graphics g) {
		g.drawImage(title, 0, 0, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == ' ') {
			actionPerformed(null);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Time");
		app.removeAll();
		app.changeScreen(new MenuScreen(app));
		time.stop();
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