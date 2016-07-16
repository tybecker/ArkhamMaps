package maps.main;

public class MapGenerator5 extends MapGenerator{

	@Override
	public void generateMap(ArkhamMap m) {
		
		m.reset();
		
		//Generate River
		int riverStart = 0;
		
		double tempRandom = Math.random() * (m.HEIGHT - 7);
		
		for(int i = 0; i < m.HEIGHT; i++){
			tempRandom = tempRandom - 1;
			if(tempRandom < 0){
				riverStart = i + 3;
				i = m.HEIGHT + 1;
			}
		}
		
		int yHeight = riverStart;
		double changeRandom = 0;
		int change = 0;
		
		for(int i = 0; i < m.WIDTH; i++){
			
			changeRandom = Math.random();
			
			if(change == -1){
				if(changeRandom < 0.5){
					change = -1;
				}else{
					change = 0;
				}
			}else if(change == 0){
				if(changeRandom < 0.34){
					change = -1;
				}else if(changeRandom < 0.67){
					change = 0;
				}else{
					change = 1;
				}
			}else if(change == 1){
				if(changeRandom < 0.5){
					change = 1;
				}else{
					change = 0;
				}
			}
			
			yHeight = yHeight + change;
			
			if(yHeight < 2){
				yHeight = 2;
			}
			
			if(yHeight > m.HEIGHT - 4){
				yHeight = m.HEIGHT - 4;
			}
			
			m.setRiver(i, yHeight, 1);
			m.setRiver(i, yHeight - 1, 1);
		}
		
		//Generate Trunk roads
				
		//Generate offshoots
		m.fillZeroes();
	}

}
