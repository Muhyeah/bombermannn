package bombermann;

import com.badlogic.gdx.math.Vector2;

public class BlockBomb extends Block {

	private int timeleft;
	private int range;
	private boolean stop;
	

	public BlockBomb(Vector2 pos, int range) {
		super(true, pos, "bomb");
		
		this.range = range;
		this.timeleft = 50;
		this.stop = false;
	}
	
	public BlockBomb(Vector2 pos) {
		super(true, pos, "bomb");
		
		this.range = 3;
		timeleft = 50;
	}

	public int countdown(){
		if(stop)
			return 0;
		return timeleft -= 1;
	}
	
	public int getc(){
		return timeleft;
	}
	
	public void stop(){
		this.stop = true;
	}
	/*
	
	public boolean canExplode(){
		if(timeleft <= 0)
			return true;
		return false;
	}
	
	public boolean isExplosion() {
		return explosion;
	}

	public void explode() {
		this.explosion = true;
	}
	*/
	public int getRange(){
		return range;
	}
	
}
