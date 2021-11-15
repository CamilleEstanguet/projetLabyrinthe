import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		
		app.setDisplayMode(960, 960, false);
		app.setAlwaysRender(true);
		
		app.start();

	}
}
