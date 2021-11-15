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
	Character player = new Character();
	Character player2 = new Character();
	public SetupClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer container) throws SlickException //Implementation des elements presents au debut du jeu
	{
		map = new TiledMap("data/maps/mapDoubleLaby1.tmx");
		knight = new Image("data/Jean-Pascal.png");
		
		player.setSpawn(2,2);
		player.sendToSpawn();
		player.setSprite(knight);
		player2.setSpawn(17, 2);
		player2.sendToSpawn();
		player2.setSprite(knight);

		
	}
	
	public void update(GameContainer container, int delta) throws SlickException //Implementation des mechaniques de jeu
	{
		Input input = container.getInput();        
		///==============================INTERACTIONS AVEC LA MAP===================================================
        int wallLayer = map.getLayerIndex("walls");
        int holeLayer = map.getLayerIndex("holes");
        
        map.getTileId(0, 0, wallLayer);
        if(input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)) {
        	if(map.getTileId((int)player.getX()+1, (int)player.getY(), wallLayer)==0) {
        		player.setX(player.getX()+ 1);
        	}
        	if(map.getTileId((int)player2.getX()+1, (int)player2.getY(), wallLayer)==0) {
        		player2.setX(player2.getX()+ 1);
        	}
        }
        if(input.isKeyPressed(Input.KEY_Q) || input.isKeyPressed(Input.KEY_LEFT)) {
        	if(map.getTileId((int)player.getX()-1, (int)player.getY(), wallLayer)==0) {
        		player.setX(player.getX() - 1);
        	}
        	if(map.getTileId((int)player2.getX()-1, (int)player2.getY(), wallLayer)==0) {
        		player2.setX(player2.getX() - 1);
        	}
        }
        if(input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN)) {
        	if(map.getTileId((int)player.getX(), (int)player.getY()+1, wallLayer)==0) {
        		player.setY(player.getY()+ 1);
        	}
        	if(map.getTileId((int)player2.getX(), (int)player2.getY()+1, wallLayer)==0) {
        		player2.setY(player2.getY()+ 1);
        	}
        }
        if(input.isKeyPressed(Input.KEY_Z) || input.isKeyPressed(Input.KEY_UP)) {
        	if(map.getTileId((int)player.getX(), (int)player.getY()-1, wallLayer)==0) {
        		player.setY(player.getY() - 1);
        	}
        	if(map.getTileId((int)player2.getX(), (int)player2.getY()-1, wallLayer)==0) {
        		player2.setY(player2.getY() - 1);
        	}
        }
        
        if(map.getTileId((int)player.getX(), (int)player.getY(), holeLayer)!= 0 || map.getTileId((int)player2.getX(), (int)player2.getY(), holeLayer) != 0) {
        	player.sendToSpawn();
        	player2.sendToSpawn();
        }
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException //Implementation des graphismes du jeu
	{
		
		map.render(0, 0);	
		player.render();
		player2.render();
	}


}
