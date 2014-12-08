package bombermann;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// Omsætter information til grafik

public class Renderer {

	private State state;

	private float w;
	private float h;
	
	private OrthographicCamera camera;
	private SpriteBatch batch;

	private Texture wall;
	private Texture bomb;
	private Texture p0;
	private Texture p2;
	
	private long prevtime;

	private Texture expc;
	private Texture exph;
	private Texture expv;
	private Texture expu;
	private Texture expr;
	private Texture expd;
	private Texture expl;
	
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
		bomb = new Texture(Gdx.files.local("src/assets/bomb.png"));
		
		expc = new Texture(Gdx.files.local("src/assets/expc.png"));
		exph = new Texture(Gdx.files.local("src/assets/exph.png"));
		expv = new Texture(Gdx.files.local("src/assets/expv.png"));
		expu = new Texture(Gdx.files.local("src/assets/expu.png"));
		expr = new Texture(Gdx.files.local("src/assets/expr.png"));
		expd = new Texture(Gdx.files.local("src/assets/expd.png"));
		expl = new Texture(Gdx.files.local("src/assets/expl.png"));
		
		p0 = new Texture(Gdx.files.local("src/assets/pp.png"));
		p2 = new Texture(Gdx.files.local("src/assets/pp2.png"));
		
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
				b.setTexture(p2);
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
		
		if(!state.getRunning()){
			batch.draw(state.getWinner().equals("player0")?p0:p2, 150f, 0f, 1000f, 1000f);

			batch.end();
			return;
		}
		
		
		Block[] tiles = state.getTiles();
				
		for(Block b: tiles){
			if(b == null){
				break;
			}
			
			if(b.getType().equals("bomb")){
				BlockBomb bomb = (BlockBomb) b;
				if(bomb.getc() < 10){
					bomb.setTexture(expc);

					Vector2[] v;
					v = new Vector2[bomb.getRange()];
					
					for(int d = 0; d<4;d++){
						Vector2 dir;
						Texture expm;
						Texture expe;
						switch(d){
						case 0:
							dir = Block.VUP;
							expm = expv;
							expe = expu;
							break;
						case 1:
							dir = Block.VRIGHT;
							expm = exph;
							expe = expr;
							break;
						case 2:
							dir = Block.VDOWN;
							expm = expv;
							expe = expd;
							break;
						case 3:
							dir = Block.VLEFT;
							expm = exph;
							expe = expl;
							break;
						default:
							dir = Block.VUP;
							expm = expv;
							expe = expu;
						}
						for(int c = 0; c < bomb.getRange();c++){
							v[c] = new Vector2(c<1?bomb.getPos():v[c-1]).add(dir);
							boolean coll = false;
							for(Block bl: tiles){
								if(bl == null){
									break;
								}
								if(v[c].equals(bl.getPos()))
								{
									if(bl.isSolid())
										coll = true;

									String type = bl.getType();
									if(type.equals("player0")||type.equals("player1"))
										state.gg(type.equals("player0")?"player1":"player0");
								}
							}
							if(!coll){
								batch.draw(c+1<bomb.getRange()?expm:expe, v[c].x, v[c].y, 100f, 100f);
								continue;
							}
							break;
						}
					}
				}
			}
			

			Vector2 v = b.getPos();
			batch.draw(b.getTexture(), v.x, v.y, 100f, 100f);
		}
		
		if((System.currentTimeMillis() - prevtime)>30){
			prevtime = System.currentTimeMillis();
			state.update();
		}
		
		batch.end();
		
	}
	
	public void setTexture(Block b, String type){
		if(type.equals("bomb")){
			b.setTexture(bomb);
		}
	}

}
