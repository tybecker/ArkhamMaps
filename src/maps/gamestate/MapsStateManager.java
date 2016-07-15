package maps.gamestate;

import java.awt.Graphics;
import java.util.Stack;

public class MapsStateManager {
	
	public Stack<MapsState> states;

	public MapsStateManager(){
		states = new Stack<MapsState>();
		states.push(new MainMenuState(this));
	}
	
	public void tick(){
		states.peek().tick();
	}
	
	public void draw(Graphics g){
		states.peek().draw(g);
	}
	
	public void keyPressed(int k){
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k){
		states.peek().keyReleased(k);
	}
	
	public void mouseMoved(int x, int y){
		states.peek().mouseMoved(x, y);
	}
	
	public void mouseClicked(int x, int y){
		states.peek().mouseClicked(x, y);
	}
}
