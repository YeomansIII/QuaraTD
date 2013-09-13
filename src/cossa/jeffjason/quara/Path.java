package cossa.jeffjason.quara;

import java.awt.Graphics;
import java.util.ArrayList;

public class Path {
ArrayList<PathLocation> pathLocations = new ArrayList<PathLocation>();
ArrayList<PathLocation> rangeLocations = new ArrayList<PathLocation>();
int multiplier, infectC, passCount;
GameScreen game;

public Path(GameScreen g) {
	multiplier = 1;
	game = g;
	infectC = 0;
	//1
	for(int i=500;i>230;i-=15){
	pathLocations.add(new PathLocation(60, i));
	}
	//2
	for(int i=80;i<206;i+=15) {
	pathLocations.add(new PathLocation(i,240));
	}
	//3
	for(int i=250;i<401;i+=15) {
	pathLocations.add(new PathLocation(210,i));
	}
	//4
	for(int i=215;i<461;i+=15)  {
	pathLocations.add(new PathLocation(i,410));
	}
	//5
	for(int i=400; i>245 ; i-=15) {
	pathLocations.add(new PathLocation(460,i));
	}
	//6
	for(int x=460; x>365; x-=15){
	pathLocations.add(new PathLocation(x,250));
	}
	//7
	for(int y = 230; y>60; y-=15){
	pathLocations.add(new PathLocation( 365,y));
	}
	//8
	for(int x = 380; x<725; x+=15){
	pathLocations.add(new PathLocation(x, 65));
	}
	//9
	for(int y = 60; y<515; y+=15){
	pathLocations.add(new PathLocation(725, y));
	}
	
}

public ArrayList<PathLocation> inRange(int lX, int lY, int rX, int rY) {
	ArrayList<PathLocation> temp = new ArrayList<PathLocation>();
	for(int i=0;i<pathLocations.size(); i++) {
		if(pathLocations.get(i).inRange(lX, lY, rX, rY)) {
			temp.add(pathLocations.get(i));
			rangeLocations.add(pathLocations.get(i));
		}
	}
	return temp;
}

public void update(Graphics g) {
	for(PathLocation p: pathLocations) {
		if(p.heldInfected != null) {
		if(p.heldInfected.health<=0) {
			
			p.heldInfected = null;
		}
		}
		if(p.heldInfected != null) {
		g.drawImage(p.heldInfected.getImage(),p.x,p.y,null);
		}
	}
	if(passCount == 35) {
	pass();
	passCount=0;
	}
	passCount++;
}

public void pass()
{
	Infected temp = null;
	if(infectC < 32) {
		temp = new Infected(multiplier);
		infectC++;
	}
	else {
		infectC++;
		if(infectC==50) {
			infectC=0;
			multiplier++;
		}
	}
   for(int k = 0; k<pathLocations.size(); k++) {
       Infected temp2 =pathLocations.get(k).heldInfected;
           pathLocations.get(k).heldInfected = temp;
       temp = temp2;
   }
   if(pathLocations.get(pathLocations.size()-1).heldInfected != null) {
	   game.score--;
   }
}
}
