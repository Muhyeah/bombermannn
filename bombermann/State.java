package bombermann;

import com.badlogic.gdx.math.Vector2;

public class State {

	private Block[] tiles;
	private long prevtime;
	
	public State(){
		tiles = new Block[120];

		tiles[0] = new Player(0);
		tiles[1] = new Player(1);

		int count = 2;
		
		for(int y=0;y<9;y+=2){
			for(int x=0;x<13;x+=2){
				tiles[count++] = new Wall(new Vector2(x*100f, y*100f));
				
			}
		}

		for(float y=0;y<9;y++){
			tiles[count++] = new Wall(new Vector2(0f, y*100f));
			tiles[count++] = new Wall(new Vector2(1200f, y*100f));
		}

		for(float x=0;x<13;x++){
			tiles[count++] = new Wall(new Vector2(x*100f, 0f));
			tiles[count++] = new Wall(new Vector2(x*100f, 800f));
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
		

		Player p = (Player) tiles[0];
		int dir = p.getNextmove();

		System.out.println(p.getPos());
		
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
		
		/*
		Player p = (Player) tiles[0];
		int dir = p.getMovedir();
		
		System.out.println(dir + "  " + p.getMoveproces());
		switch (p.getMoveproces()){
		case 0:
			p.setMovedir(p.getNextmove());
			
			switch(dir){
			case Player.UP:
				p.setPos(p.getPos().add(0, 33));
				break;
			case Player.DOWN:
				p.setPos(p.getPos().add(0, -33));
				break;
			case Player.LEFT:
				p.setPos(p.getPos().add(-33, 0));
				break;
			case Player.RIGHT:
				p.setPos(p.getPos().add(33, 0));
				break;
			}
			p.setMoveproces(1);
			break;
			
		case 1:
			switch(dir){
			case Player.UP:
				p.setPos(p.getPos().add(0, 33));
				break;
			case Player.DOWN:
				p.setPos(p.getPos().add(0, -33));
				break;
			case Player.LEFT:
				p.setPos(p.getPos().add(-33, 0));
				break;
			case Player.RIGHT:
				p.setPos(p.getPos().add(33, 0));
				break;
			}
			p.setMoveproces(2);
			break;
			
		case 2:

			switch(dir){
			case Player.UP:
				p.setPos(p.getPos().add(0, 34));
				break;
			case Player.DOWN:
				p.setPos(p.getPos().add(0, -34));
				break;
			case Player.LEFT:
				p.setPos(p.getPos().add(-34, 0));
				break;
			case Player.RIGHT:
				p.setPos(p.getPos().add(34, 0));
				break;
			}
			p.setMoveproces(0);
			break;
		}*/
		
		
	}
	
}
