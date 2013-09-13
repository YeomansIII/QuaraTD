package cossa.jeffjason.quara;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Infected {

	int health, value;
	Image img;
	
	public Infected(int mult) {
		health = 4*mult;
		if(mult <= 10) 
			value = mult;
		else
			value = 10;
		
		img = new ImageIcon(getClass().getResource("data/infected.png")).getImage();
	}
	
	public boolean takeDamage(int damage) {
		health -= damage;
		if(health<=0)
			return true;
		return false;
	}

	public Image getImage() {
		return img;
	}

}
