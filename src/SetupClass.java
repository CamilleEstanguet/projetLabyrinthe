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
	
	
	private TiledMap map;
	private Image knight = null;
	private int x,y, x2, y2;
	public SetupClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException //Implementation des elements presents au debut du jeu
	{
		map = new TiledMap("data/maps/mapDoubleLaby1.tmx");
		knight = new Image("data/Jean-Pascal.png");
		
		x = 2;
		y = 2;
		x2 = 17;
		y2 = 2;
	}
	
	public void update(GameContainer container, int delta) throws SlickException //Implementation des mechaniques de jeu
	{
		Input input = container.getInput();        
		///==============================INTERACTIONS AVEC LA MAP===================================================
        int wallLayer = map.getLayerIndex("walls");
        
        map.getTileId(0, 0, wallLayer);
        if(input.isKeyPressed(Input.KEY_D)) {
        	if(map.getTileId(x+1, y, wallLayer)==0) {
        		x++;
        	}
        	if(map.getTileId(x2+1, y2, wallLayer)==0) {
        		x2++;
        	}
        }
        if(input.isKeyPressed(Input.KEY_Q)) {
        	if(map.getTileId(x-1, y, wallLayer)==0) {
        		x--;
        	}
        	if(map.getTileId(x2-1, y2, wallLayer)==0) {
        		x2--;
        	}
        }
        if(input.isKeyPressed(Input.KEY_S)) {
        	if(map.getTileId(x, y+1, wallLayer)==0) {
        		y++;
        	}
        	if(map.getTileId(x2, y2+1, wallLayer)==0) {
        		y2++;
        	}
        }
        if(input.isKeyPressed(Input.KEY_Z)) {
        	if(map.getTileId(x, y-1, wallLayer)==0) {
        		y--;
        	}
        	if(map.getTileId(x2, y2-1, wallLayer)==0) {
        		y2--;
        	}
        }
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException //Implementation des graphismes du jeu
	{
		
		map.render(0, 0);	
		knight.draw(x*32, y*32, 32, 32);
		knight.draw(x2*32, y2*32, 32, 32);
	}


}
