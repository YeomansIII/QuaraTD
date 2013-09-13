package cossa.jeffjason.quara;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;



    public  class Unit
   {
      int range,splash,damage,curX,curY,cost,upgradeC,fRate,actTime;
      Path path;
      Image img;
      GameScreen game;
      boolean isPlaced;


      public Unit(int ran,int spla, int dama,int rate, int cos, int upC, String imgsrc, GameScreen g)
      {
    	  fRate = rate;
         range = ran;
         splash = spla;
         damage = dama;
         path = g.path;
         cost = cos;
         upgradeC = upC;
         game = g;
         isPlaced = false;
         actTime=0;
         img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgsrc));
      }

       public void update(Graphics g) {
    	   if(isPlaced) { 
    		   g.drawImage(img, curX, curY, null);
    		   if(actTime==fRate) {
    		   act(); actTime=0;}
    		   actTime++;
    	   }
       }
       
       public void act()
      {
         ArrayList<PathLocation> pathLocations = getPathLocations();
         ArrayList<PathLocation> attackList = getAttackLocations(pathLocations);
         makeAttack(attackList);
      }

       public ArrayList<PathLocation> getPathLocations()
      {
         ArrayList<PathLocation> loc = new ArrayList<PathLocation>();
         loc = path.inRange(curX-range, curY+range, curX+range, curY-range);
         return loc;


      }

       public ArrayList<PathLocation> getAttackLocations(ArrayList<PathLocation> locks)
      {
         ArrayList<PathLocation> returnList = new ArrayList<PathLocation>();
         int count=0;

         for(int k = locks.size()-1; k>0; k--)
         {
            if(count<splash) {
               if(locks.get(k).getInfected() != null) {
                  returnList.add(locks.get(k));
                  count++;
               }
            }
         //if contains a unit and if it's first unit in range.
         }
         return returnList;
      }

       public void	makeAttack(ArrayList<PathLocation> attackable)
      {
         for(int k = 0; k< attackable.size(); k++) {
            if(attackable.get(k).getInfected().takeDamage(damage)) {
            	game.money += attackable.get(k).getInfected().value;
            }
         }

      }
       
       public void setLoc(int x, int y) {
    	   curX = x;
    	   curY = y;
    	   isPlaced = true;
       }
       
       public int upgrade()
       {
          range+=7;
          damage*=1.5;
          
          upgradeC*=1.65;
          return upgradeC;
       	
       }	

   }