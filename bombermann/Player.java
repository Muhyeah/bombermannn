package bombermann;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Player extends Block {

	private int nextmove;
	private int movedir;
	private boolean[] keyspressed;
	private boolean dropbomb = false;
	
	public boolean isDropbomb() {
		return dropbomb;
	}

	public void setDropbomb(boolean dropbomb) {
		this.dropbomb = dropbomb;
	}

	public boolean[] getKeyspressed() {
		return keyspressed;
	}

	public void setKeyspressed(int index, boolean pressed) {
		this.keyspressed[index] = pressed;
	}

	public int getMovedir() {
		return movedir;
	}

	public void setMovedir(int movedir) {
		this.movedir = movedir;
	}

	public Player(int i){
		super(false, i==0? new Vector2(100f, 100f):new Vector2(500f, 100f), "player"+i);

		keyspressed = new boolean[2000];
		nextmove = 0;
		movedir = 0;
		
	}

	public int getNextmove() {
		return nextmove;
	}

	public void setNextmove(int nextmove) {
		this.nextmove = nextmove;
	}

	public static int keyTokey(int i){
		int nm;
		switch(i) {
		case Keys.LEFT:
		case Keys.A:
			nm = Player.LEFT;
			break;
		case Keys.RIGHT:
		case Keys.D:
			nm = Player.RIGHT;
			break;
		case Keys.UP:
		case Keys.W:
			nm = Player.UP;
			break;
		case Keys.DOWN:
		case Keys.S:
			nm = Player.DOWN;
			break;
		default:
			nm = i;
		}
		return nm;
	}

	public static boolean isp2(int i){

		switch(i) {
		case Keys.A:
		case Keys.D:
		case Keys.W:
		case Keys.S:
			return true;
		default:
			return false;
		}
		
	}

	
	
}
