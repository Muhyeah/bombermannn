package bombermann;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


public class Block {
	

	public final static int UP = 1111; 
	public final static int DOWN = 1112; 
	public final static int LEFT = 1113; 
	public final static int RIGHT = 1114;
	
	public final static int UP2 = 1121; 
	public final static int DOWN2 = 1122; 
	public final static int LEFT2 = 1123; 
	public final static int RIGHT2 = 1124;

	public final static Vector2 VUP = new Vector2(0, 100);
	public final static Vector2 VDOWN = new Vector2(0, -100);
	public final static Vector2 VLEFT = new Vector2(-100, 0);
	public final static Vector2 VRIGHT = new Vector2(100, 0);
	
	public final static Vector2 GONE = new Vector2(-1000, -1000);
	
	private Texture texture;
	private Vector2 pos;
	private boolean solid;
	private String type;



	public boolean collides(int dir, Block[] tiles) {
		for(Block b:tiles){
			if(b == null){
				break;
			}
			switch(dir){
			case UP:
				if(new Vector2(pos).add(VUP).equals(b.pos))
					return true;
				break;
			case DOWN:
				if(new Vector2(pos).add(VDOWN).equals(b.pos))
					return true;
				break;
			case LEFT:
				if(new Vector2(pos).add(VLEFT).equals(b.pos))
					return true;
				break;
			case RIGHT:
				if(new Vector2(pos).add(VRIGHT).equals(b.pos))
					return true;
				break;
			default:
				break;
			}
			
		}
		
		return false;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture t) {
		this.texture = t;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public boolean isSolid() {
		return solid;
	}
	
	public String getType(){
		return type;
	}

	public Block(boolean solid, Vector2 pos, String type){
		this.solid = solid;
		this.pos = pos;
		this.type = type;
		
	}
	
}