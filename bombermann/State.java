package bombermann;

import com.badlogic.gdx.math.Vector2;

public class State {

	private Block[] tiles;
	private long prevtime;
	private int cycle; //0, 1, 2
	private int tilescount;
	private Renderer renderer;
	private boolean running;
	private String winner;
	
	public State(){
		cycle = 0;
		running = true;
		tiles = new Block[1000];

		tiles[0] = new Player(0);
		tiles[1] = new Player(1);

		tilescount = 2;
		
		for(int y=0;y<9;y+=2){
			for(int x=0;x<13;x+=2){
				tiles[tilescount++] = new Wall(new Vector2(x*100f, y*100f));
				
			}
		}

		for(float y=0;y<9;y++){
			tiles[tilescount++] = new Wall(new Vector2(0f, y*100f));
			tiles[tilescount++] = new Wall(new Vector2(1200f, y*100f));
		}

		for(float x=0;x<13;x++){
			tiles[tilescount++] = new Wall(new Vector2(x*100f, 0f));
			tiles[tilescount++] = new Wall(new Vector2(x*100f, 800f));
		}
		
		prevtime = System.currentTimeMillis();
	}

	public Block[] getTiles() {
		return tiles;
	}

	public void setTiles(Block[] tiles) {
		this.tiles = tiles;
	}

	public void update() {
		

		if(cycle++ == 2){
			
			for(int i = 0;i<2;i++){

				Player p = (Player) tiles[i];
				int dir = p.getNextmove();
				
				if(p.isDropbomb()){
					BlockBomb b = new BlockBomb(new Vector2(p.getPos()));
					renderer.setTexture(b, "bomb");
					tiles[tilescount++] = b;
					p.setDropbomb(false);
				}

				for(Block b: tiles){
					if(b==null)
						continue;
					if(b.getType().equals("bomb")){
						BlockBomb bomb = (BlockBomb) b;
						if(bomb.countdown() <= 0){
							bomb.setPos(Block.GONE);
							bomb.stop();
						}
					}
				}
				
				
				boolean[] keys = p.getKeyspressed();
				if(!keys[dir]){
					dir = 0;
					p.setNextmove(0);
					for(int key=Block.UP;key<=Block.RIGHT;key++){
						if(keys[key]==true){
							dir = key;
						}
					}
				}
				
				if(!p.collides(dir, tiles)){
					
					switch(dir){
					case Player.UP:
						p.setPos(p.getPos().add(0, 100));
						break;
					case Player.DOWN:
						p.setPos(p.getPos().add(0, -100));
						break;
					case Player.LEFT:
						p.setPos(p.getPos().add(-100, 0));
						break;
					case Player.RIGHT:
						p.setPos(p.getPos().add(100, 0));
						break;
					}
				}
			}

		
			cycle = 0;
		}
		
	}
	
	public boolean getRunning(){
		return running;
	}
	public String getWinner(){
		return winner;
	}

	public void setRenderer(Renderer renderer) {
		// TODO Auto-generated method stub
		this.renderer = renderer;
	}

	public void gg(String type) {
		// TODO Auto-generated method stub
		winner = type;
		running = false;
	}
	
}
