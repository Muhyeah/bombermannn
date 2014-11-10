package bombermann;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Omsætter information til grafik

public class Renderer {

	private State state;

	private float w;
	private float h;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Sprite sprite;

	private Texture wall;
	
	public Renderer(State state) {
		this.state = state;

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1300, h/w*1300);
		camera.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		wall = new Texture(Gdx.files.local("src/assets/wall.png"));
	}
	
	public void render(){
		
		System.out.println(h/w);

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera.setToOrtho(false, 1300, h/w*1300);
		batch.setProjectionMatrix(camera.combined);
		
		//Gdx.gl20.glViewport( 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
		Gdx.gl20.glClearColor( 1, 1, 1, 1 );
		Gdx.gl20.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		batch.begin();
		for(float j=0;j<900;j+=200){
			for(float i=0;i<1300;i+=200){
				batch.draw(wall, i, j, 100f, 100f);
			}
		}

		for(float x=0;x<900;x+=100){
			batch.draw(wall, 0f, x, 100f, 100f);
			batch.draw(wall, 1200f, x, 100f, 100f);
		}

		for(float x=0;x<1300;x+=100){
			batch.draw(wall, x, 0f, 100f, 100f);
			batch.draw(wall, x, 800f, 100f, 100f);
		}
		
		batch.end();
		
	}

}
