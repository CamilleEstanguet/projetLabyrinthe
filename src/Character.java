import org.newdawn.slick.Image;

public class Character {
	private float x,y, xSpawn, ySpawn;
	private Image sprite;
	
	public Character() {
		x = 1;
		xSpawn = x;
		y = 1;
		ySpawn = y;
		sprite = null;
	}
	
	public Character( float x, float y, Image sprite ) {
		this.x = x;
		xSpawn = x;
		this.y = y;
		ySpawn = y;
		this.sprite = sprite;
	}
	
	public void setX(float f) { x =f; }
	public float getX() { return x; }
	public void setY(float f) { y =f; }
	public float getY() { return y; }
	public void setSprite(Image i) { sprite = i; }
	public Image getSprite() { return sprite; }
	
	public void render() {
		sprite.draw(x*32, y*32, 32, 32);
	}
	
	public void setSpawn(float x, float y) {
		xSpawn = x;
		ySpawn = y;
	}
	
	public void sendToSpawn() {
		x = xSpawn;
		y = ySpawn;
	}
	
}
