package bombermann;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Block {

	private int nextmove;
	private int moveproces;
	private int movedir;
	
	public int getMovedir() {
		return movedir;
	}

	public void setMovedir(int movedir) {
		this.movedir = movedir;
	}

	public Player(int i){
		super(false, i==0? new Vector2(100f, 100f):new Vector2(500f, 100f), "player"+i);
		
		System.out.println(getType());
		nextmove = 0;
		moveproces = 0;
		movedir = 0;
		
	}

	public int getNextmove() {
		return nextmove;
	}

	public void setNextmove(int nextmove) {
		this.nextmove = nextmove;
	}

	public int getMoveproces() {
		return moveproces;
	}

	public void setMoveproces(int moveproces) {
		this.moveproces = moveproces;
	}
	
	public static int keyTokey(int i){
		int nm;
		switch(i) {
		case Keys.LEFT:
			nm = Player.LEFT;
			break;
		case Keys.RIGHT:
			nm = Player.RIGHT;
			break;
		case Keys.UP:
			nm = Player.UP;
			break;
		case Keys.DOWN:
			nm = Player.DOWN;
			break;
		default:
			nm = 0;
		}
		return nm;
	}
	
}
