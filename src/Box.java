import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Box {

    private float x1,y1,     //haut gauche
                  x2, y2;     //bas droite
    
    private float width, height; 
    
    public Box (float x1, float y1, float x2, float y2)
    {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        width =  x2-x1;
        height = y2-y1;
    }
    
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        g.fillRect(x1, y1, width, height);
    }
    
    public float getX1() { return x1; }
    public float getX2() { return x2; }
    public float getY1() { return y1; }
    public float getY2() { return y2; }
    
    public void setPos (float x, float y)
    {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }
    
    public boolean collide (Box boite)
    {
        if ( y2 < boite.getY1()) return false;
        if ( x2 < boite.getX1()) return false;
        if ( y1 > boite.getY2()) return false;
        if ( x1 > boite.getX2()) return false;
        
        return true;
    }
}
