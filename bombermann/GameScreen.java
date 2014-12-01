package bombermann;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen, InputProcessor {

	private State state;
	private Renderer renderer;
	private Input input;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		state = new State();
		renderer = new Renderer(state);
		state.setRenderer(renderer);
		input = new Input(state);

        Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		
		renderer.render();
		
	}
	
	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub

		Player p1 = (Player) state.getTiles()[0];
		Player p2 = (Player) state.getTiles()[1];
		int key = Player.keyTokey(arg0);
		Player p;
		if(Player.isp2(arg0)){
			p = p2;
		}
		else {
			p = p1;
		}
		switch(key){
		case Player.UP:
		case Player.DOWN:
		case Player.LEFT:
		case Player.RIGHT:
			p.setNextmove(key);
			p.setKeyspressed(key, true);
			break;
		case Keys.SPACE:
			p1.setDropbomb(true);
			break;
		case Keys.NUM_1:
			p2.setDropbomb(true);
			break;
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int arg0) {
		Player p1 = (Player) state.getTiles()[0];
		Player p2 = (Player) state.getTiles()[1];
		int key = Player.keyTokey(arg0);
		Player p;
		if(Player.isp2(arg0)){
			p = p2;
		}
		else {
			p = p1;
		}
		p.setKeyspressed(key, false);
		
		return true;
	}
	
	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	
}
	
