package cossa.jeffjason.quara;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class ScreenState {

	QuaraContainer app;
	
	public ScreenState(QuaraContainer app) {
		this.app = app;
	}
	
	public abstract void update(Graphics g);
	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);

	public abstract void mouseClicked(MouseEvent arg0);
	public abstract void mouseEntered(MouseEvent arg0) ;
	public abstract void mouseExited(MouseEvent arg0) ;
	public abstract void mousePressed(MouseEvent arg0) ;
	public abstract void mouseReleased(MouseEvent arg0) ;
}
