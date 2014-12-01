package bombermann;

import com.badlogic.gdx.math.Vector2;

public class BlockBomb extends Block {

	private int timeleft;
	private int range;
	private boolean explosion;
	
	public boolean isExplosion() {
		return explosion;
	}

	public void explode() {
		this.explosion = true;
	}

	public BlockBomb(Vector2 pos, int range) {
		super(true, pos, "bomb");
		
		this.range = range;
		this.timeleft = 50;
		this.explosion = false;
	}
	
	public BlockBomb(Vector2 pos) {
		super(true, pos, "bomb");
		
		this.range = 3;
		timeleft = 50;
	}

	public void countdown(){
		timeleft -= 1;
		System.out.println(timeleft);
	}
	
	public boolean canExplode(){
		if(timeleft <= 0)
			return true;
		return false;
	}
	
	public int getRange(){
		return range;
	}
	
}
