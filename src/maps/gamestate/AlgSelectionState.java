package maps.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import maps.main.BlankMapGenerator;
import maps.main.MapGenerator1;
import maps.main.MapGenerator2;
import maps.main.MapGenerator3;
import maps.main.MapGenerator4;
import maps.main.MapGenerator5;
import maps.main.MapGenerator6;
import maps.main.MapGenerator7;
import maps.main.MapGenerator8;

public class AlgSelectionState extends MapsState{
	
	private String[] options = {"EmptyMap", "Algorithm 1: simple", "Algorithm 2: Steady state", "Algorithm 3: Weighted Generator", "Algorithm 4: Random Rivers", "Algorithm 5: Less Random Rivers", "Algorithm 6: The Bounded Map", "Algorithm 7: Slightly Less Bounded Map", "Algorithm 8: SetPieces", "Back"};
	private int currentSelection = 0;

	public AlgSelectionState(MapsStateManager msm) {
		super(msm);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.BLUE);
			}else{
				g.setColor(Color.BLACK);
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 36));
			g.drawString(options[i], 50, 70 + i* 50);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection >= options.length){
				currentSelection = 0;
			}
		//If the up key is pressed, move the selection up one. 
		}else if (k == KeyEvent.VK_UP){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER){
			if(currentSelection  == 0){
				msm.states.push(new MapGeneratorState(msm, new BlankMapGenerator()));
			}else if(currentSelection == 1){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator1()));
			}else if(currentSelection == 2){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator2()));
			}else if(currentSelection == 3){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator3()));
			}else if(currentSelection == 4){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator4()));
			}else if(currentSelection == 5){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator5()));
			}else if(currentSelection == 6){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator6()));
			}else if(currentSelection == 7){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator7()));
			}else if(currentSelection == 8){
				msm.states.push(new MapGeneratorState(msm, new MapGenerator8()));
			}else if(currentSelection == 9){
				msm.states.pop();
			}
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
