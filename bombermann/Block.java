package bombermann;

import com.badlogic.gdx.graphics.Texture;

// Fælles karakteristika ved alle objekter på pladen

public class Block {
	private boolean solid;

	private Texture texture;
	
	public Block(boolean solid, Texture texture){
		this.solid = solid;
		this.texture = texture;
	}
	
}