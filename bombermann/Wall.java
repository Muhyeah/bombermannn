package bombermann;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Wall extends Block{

	public Wall() {
		Texture texture = new Texture(Gdx.files.local("src/assets/wall.png"));
		
		super(true, texture);
		
	}
	
	
}
