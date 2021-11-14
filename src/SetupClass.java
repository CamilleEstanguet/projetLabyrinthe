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
		
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		//g.drawString("Hello world!", 50, 50);
		
		knight.draw(600, 400, 50, 50);
		tileset.draw(100, 100, 200, 200);
		
	}


}
