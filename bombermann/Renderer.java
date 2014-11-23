package bombermann;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// Omsætter information til grafik

public class Renderer {

	private State state;

	private float w;
	private float h;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Sprite sprite;

	private Texture wall;
	private Texture p0;
	
	private long prevtime;
	
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
		p0 = new Texture(Gdx.files.local("src/assets/pp.png"));
		
		Block[] tiles = state.getTiles();
		for(Block b:tiles){
			if(b == null){
				break;
			}

			if(b.getType().equals("wall")){
				b.setTexture(wall);
			}
			
			if(b.getType().equals("player0")){
				b.setTexture(p0);
			}
			
			if(b.getType().equals("player1")){
				b.setTexture(p0);
			}
		}
	}
	
	public void render(){

		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		camera.setToOrtho(false, 1300, h/w*1300);
		batch.setProjectionMatrix(camera.combined);
		
		//Gdx.gl20.glViewport( 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
		Gdx.gl20.glClearColor( 1, 1, 1, 1 );
		Gdx.gl20.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
		
		batch.begin();
		
		Block[] tiles = state.getTiles();
				
		for(Block b: tiles){
			if(b == null){
				break;
			}
			Vector2 v = b.getPos();
			batch.draw(b.getTexture(), v.x, v.y, 100f, 100f);
		}
		
		if((System.currentTimeMillis() - prevtime)>100){
			prevtime = System.currentTimeMillis();
			state.update();
		}
		
		batch.end();
		
	}

}
