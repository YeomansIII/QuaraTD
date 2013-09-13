package cossa.jeffjason.quara;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameScreen extends ScreenState{

Path path;
JPanel unitbuttons;
JButton tankB,turretB,bunkerB,artB;
ArrayList<Unit> activeUnits;
Image map;
Unit curPlace;
int money, score;
double weightRatio, time; 
Font gameoverFont, normFont;

	public GameScreen(QuaraContainer app) {
		super(app);
		
		map = Toolkit.getDefaultToolkit().getImage(getClass().getResource("data/map.png"));
		gameoverFont = new Font("Times New Roman",Font.PLAIN,30);
		normFont = new Font("Times New Roman",Font.PLAIN,15);
		score = 20;
		weightRatio = 0.01;
		time = 1;
		activeUnits = new ArrayList<Unit>();
		path = new Path(this);
		money = 250;
		app.setLayout(new BorderLayout());
		unitbuttons = new JPanel(new GridLayout(2,3));
		tankB = new JButton("Siege Tank: 300"); tankB.addActionListener(new TankButton(this));
		turretB = new JButton("Turret: 50");  turretB.addActionListener(new TurretButton(this));
		bunkerB = new JButton("Bunker: 200");  bunkerB.addActionListener(new BunkerButton(this));
		artB = new JButton("Artillery: 500");  artB.addActionListener(new ArtButton(this));
		unitbuttons.add(tankB);
		unitbuttons.add(turretB);
		unitbuttons.add(bunkerB);
		unitbuttons.add(artB);
		app.add(unitbuttons,BorderLayout.SOUTH);
	}

	public void update(Graphics g) {
		long frametime = System.currentTimeMillis();
		g.drawImage(map, 0, 0, null);
		g.setColor(Color.black);
		g.setFont(normFont);
		path.update(g);
				if(activeUnits.size()>0) {
			for(int i=0;i<activeUnits.size();i++) {
				activeUnits.get(i).update(g);
			}
		}
		if(curPlace != null) {
			Point p = MouseInfo.getPointerInfo().getLocation();
			SwingUtilities.convertPointFromScreen(p, app);
			g.drawImage(curPlace.img,p.x,p.y,null);
		}
		g.setColor(Color.black);
		g.drawString("$"+money, 5, 500);
		g.drawString(""+score,775,500);
		frametime = System.currentTimeMillis() - frametime;
		time = time * (1.0 - weightRatio) + frametime * weightRatio;
		g.drawString(""+time,5,10);
		g.drawString("Level: "+path.multiplier,390,500);
		if(score<=0) {
			g.setFont(gameoverFont);
			g.setColor(Color.red);
			g.drawString("Game Over!",285,350);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
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
	public void mouseClicked(MouseEvent arg0) {
		if(curPlace != null) {
			curPlace.setLoc(arg0.getX(), arg0.getY());
			curPlace = null;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	public void addUnit(Unit u){
		activeUnits.add(u);
		curPlace = u;
	}
}

class TankButton implements ActionListener {
	GameScreen game;
	public TankButton(GameScreen game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(game.money>=250) {
			game.money -= 300;
			game.addUnit(new SiegeTank(game));
		}
	}
}
class TurretButton implements ActionListener {
	GameScreen game;
	public TurretButton(GameScreen game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(game.money>=50) {
			game.money -= 50;
			game.addUnit(new Turret(game));
		}
	}
}
class BunkerButton implements ActionListener {
	GameScreen game;
	public BunkerButton(GameScreen game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(game.money>=200) {
			game.money -= 200;
			game.addUnit(new Bunker(game));
		}
	}
}
class ArtButton implements ActionListener {
	GameScreen game;
	public ArtButton(GameScreen game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(game.money>=250) {
			game.money -= 250;
			game.addUnit(new Artillary(game));
		}
	}
}
