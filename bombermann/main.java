package bombermann;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "bombermann";
		cfg.width = 600;
		cfg.height = 500;
		
		new LwjglApplication(new bombermann(), cfg);
	}
}