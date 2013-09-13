package cossa.jeffjason.quara;

    public class SiegeTank extends Unit
   {

       public SiegeTank(GameScreen game)
      {
         super(150, 3, 5,100,300,150, "data/siegetank.png", game);
      }

       public void relocate(int x, int y)
      {
         curX= x;
         curY=y;

      }
   }