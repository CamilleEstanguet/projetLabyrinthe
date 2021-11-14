import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class SetupClass extends BasicGame {
	
	private Image knight = null;
	private Image tileset = null;
	private float x = 600, y = 400;
	private float x2 = 100, y2 = 100;
	Random rand = new Random();

	public SetupClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException {
		knight = new Image("data/Jean-Pascal.png");
		tileset = new Image ("data/maze.png");
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			x += 0.1 * delta;
		}
		if(input.isKeyDown(Input.KEY_Z)|| input.isKeyDown(Input.KEY_UP)) {
			y -= 0.1 * delta;
		}
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
			y += 0.1 * delta;
		}
		if(input.isKeyDown(Input.KEY_Q) || input.isKeyDown(Input.KEY_LEFT)) {
			x -= 0.1 * delta; 
		}
		
		float d = (x-x2) * (x-x2) + (y-y2) * (y-y2);
		float targetD = (15+15) * (15+15);
		
		if(d < targetD) {
			x2 = rand.nextInt(750);
			y2 = rand.nextInt(550);
		}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		//g.drawString("Hello world!", 50, 50);
		
		knight.draw(x, y, 50, 50);
		knight.draw(x2, y2, 50, 50);
		//tileset.draw(100, 100, 200, 200);
		
	}


}
