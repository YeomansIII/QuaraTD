package cossa.jeffjason.quara;

	public class PathLocation {
		int x, y;
		Infected heldInfected;

	public PathLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean inRange(int lX, int lY, int rX, int rY) {
		//System.out.println("lX: "+lX+" lY: "+lY+"      rX: "+rX+" rY: "+rY);
		//System.out.println("location x,y: "+x+", "+y);
		if((x>lX && x<rX) && (y<lY && y>rY))  {
			return true;
		}
		return false;
	}
	
	public void hold(Infected unit) {
		heldInfected = unit;
	}


	public Infected getInfected() {
		return heldInfected;
	}
}
