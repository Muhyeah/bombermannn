package bombermann;

import com.badlogic.gdx.graphics.Texture;

// F�lles karakteristika ved alle objekter p� pladen

public class Block {
	private boolean solid;

	private Texture texture;
	
	public Block(boolean solid, Texture texture){
		this.solid = solid;
		this.texture = texture;
	}
	
}