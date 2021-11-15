import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



public class SetupClass extends BasicGame {
	
	private Image knight = null;
	private float x = 600, y = 400;
	private float x2 = 100, y2 = 100;
	Random rand = new Random();
	
	private Box box1, box2;
	
	private TiledMap map;

	public SetupClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException {
		knight = new Image("data/Jean-Pascal.png");
		
		box1 = new Box(300, 300, 400, 350);
        box2 = new Box(500, 500, 550, 550);
        
		map = new TiledMap("data/maps/map1.tmx");
		
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		
		///=====================================DEPLACEMENTS=======================================================
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)) {
			x += 0.5 * delta;
//			x2 += 0.5 * delta;
		}
		if(input.isKeyDown(Input.KEY_Z)|| input.isKeyDown(Input.KEY_UP)) {
			y -= 0.5 * delta;
//			y2 -= 0.5 * delta;
		}
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) {
			y += 0.5 * delta;
//			y2 += 0.5 * delta;
		}
		if(input.isKeyDown(Input.KEY_Q) || input.isKeyDown(Input.KEY_LEFT)) {
			x -= 0.5 * delta; 
//			x2 -= 0.5 * delta; 
		}
		
		///================================HITBOX CIRCULAIRE, CHEVALIER==============================================
		float d = (x-x2) * (x-x2) + (y-y2) * (y-y2);
		float targetD = (15+15) * (15+15);
		
		if(d < targetD) {
			x2 = rand.nextInt(750);
			y2 = rand.nextInt(550);
		}
		
		///====================================HITBOX BOITE, CUBE=====================================================
		box2.setPos(x, y);
        if (box1.collide(box2))
        {
            container.getGraphics().setColor(Color.red); //si collision, boite -> rouge
        }
        else
        {
            container.getGraphics().setColor(Color.white); //blanche par défaut
        }
        
		///==============================INTERACTIONS AVEC LA MAP===================================================
        int objectLayer = map.getLayerIndex("objects");
        
        map.getTileId(0, 0, objectLayer);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		
		map.render(0, 0);
		knight.draw(x, y, 32, 32);
		knight.draw(x2, y2, 32, 32);
		
		box1.render(container, g);
        box2.render(container, g);
		
		
	}


}
