package cossa.jeffjason.quara;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;



public class QuaraContainer extends JPanel implements KeyListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ScreenState curScreen;
	private BufferedImage bImage;
	private Graphics buffer;
	int a, timer;
	Timer time;
	
	public QuaraContainer() {
		timer = 16;
		addKeyListener(this);
		addMouseListener(this);
		bImage = new BufferedImage(800, 575, BufferedImage.TYPE_INT_RGB);
		buffer = bImage.getGraphics();
		setFocusable(true);
		setLayout(new FlowLayout());
		curScreen = new TitleScreen(this);
		time = new Timer(timer,this);
		time.start();
		a=0;
		
	}
	
	@Override
	public java.awt.Component add(java.awt.Component comp) {
		System.out.println("Adding");
		return super.add(comp);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bImage,0,0,getWidth(),getHeight(),null);
	}
	
	public void changeScreen(ScreenState screen) {
		//removeAll();
		curScreen = screen;
		revalidate();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		curScreen.keyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		curScreen.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
		curScreen.keyTyped(arg0);
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("Repaint");
		buffer.setColor(Color.white);
		buffer.fillRect(0,0,800,800);
		curScreen.update(buffer);
		//buffer.drawRect(a, y, width, height)
		//a+=1;
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Mouse clicked: "+arg0.getX()+", "+arg0.getY());
		curScreen.mouseClicked(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		curScreen.mouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		curScreen.mouseExited(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		curScreen.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		curScreen.mouseReleased(arg0);
	}
	

} 
