package maps.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import maps.main.ArkhamMap;
import maps.main.BlankMapGenerator;
import maps.main.MapGenerator;
import maps.main.MapsPanel;

public class MapGeneratorState extends MapsState{

	MapGenerator mg = new BlankMapGenerator();
	
	ArkhamMap arkhamMap = new ArkhamMap();
	
	private int currentSelection = -1;
	
	public MapGeneratorState(MapsStateManager msm) {
		super(msm);
		// TODO Auto-generated constructor stub
	}
	
	public MapGeneratorState(MapsStateManager msm, MapGenerator mg) {
		super(msm);
		
		this.mg = mg;
		// TODO Auto-generated constructor stub
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
		g.setColor(Color.white);
		g.fillRect(0, 0, MapsPanel.WIDTH, MapsPanel.HEIGHT);
		arkhamMap.draw(g, 30, 30);
		
		
		g.setFont(new Font("Arial", Font.PLAIN, 36));
		if(currentSelection == 0){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.blue);
		}
		g.drawString("BACK", 100, 650);
		if(currentSelection == 1){
			g.setColor(Color.red);
		}else{
			g.setColor(Color.blue);
		}
		g.drawString("GENERATE MAP", 500, 650);
		
		//g.setColor(Color.red);
		//g.drawLine(100, 620, 200, 650);
		//g.drawLine(500, 620, 784, 650);
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		// TODO Auto-generated method stub
		if(x > 100 && x < 200 && y > 620 && y < 650){
			currentSelection = 0;
		}else if(x > 500 && x < 784 && y > 620 && y < 650){
			currentSelection = 1;
		}else{
			currentSelection = -1;
		}
	}

	@Override
	public void mouseClicked(int x, int y) {
		// TODO Auto-generated method stub
		if(currentSelection == -1){
			
		}else if(currentSelection == 0){
			msm.states.pop();
		}else if(currentSelection == 1){
			mg.generateMap(arkhamMap);
		}
	}

}
