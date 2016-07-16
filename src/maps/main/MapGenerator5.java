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
			
			if(yHeight < 3){
				yHeight = 3;
			}
			
			if(yHeight > m.HEIGHT - 4){
				yHeight = m.HEIGHT - 4;
			}
			
			m.setRiver(i, yHeight, 1);
			m.setRiver(i, yHeight - 1, 1);
		}
		
		//Generate Trunk roads
		for(int i = 0; i < m.HEIGHT; i++){
			m.setTile(14, i, 6);
		}
		
		int mainEastRoad = 0;
		if(m.getRiver(14, 9) == 0 && m.getRiver(15, 9) == 0){
			m.setTile(14, 9, 5);
			mainEastRoad = 9;
		}else{
			m.setTile(14, 6, 5);
			mainEastRoad = 6;
		}
		
		for(int i = 15; i < m.WIDTH; i++){
			if(m.getRiver(i + 1, mainEastRoad) == 0){
				m.setTile(i, mainEastRoad, 7);
			}else if(m.getRiver(i, mainEastRoad + 1) == 1){
				m.setTile(i, mainEastRoad, 11);
				mainEastRoad = mainEastRoad - 1;
				m.setTile(i, mainEastRoad, 9);
			}else if(m.getRiver(i, mainEastRoad - 1) == 1){
				m.setTile(i, mainEastRoad, 10);
				mainEastRoad = mainEastRoad + 1;
				m.setTile(i, mainEastRoad, 8);
			}else{
				m.setTile(i, mainEastRoad, 7);
			}
		}
		
		
		for(int i = 0; i < m.WIDTH; i++){
			for(int j = 0; j < m.HEIGHT; j++){
				if(m.hasAdjacentConnectedIntersection(i, j)){
					
				}else{
					if(m.getTile(i, j) == 6){
						double random = Math.random();
						if(m.getRiver(i + 1, j) == 1 && m.getRiver(i, j) == 0){
							if(random < 0.3){
								m.setTile(i, j, 3);
							}
						}else if(m.getRiver(i - 1, j) == 1 && m.getRiver(i, j) == 0){
							if(random < 0.3){
								m.setTile(i, j, 5);
							}
						}else if (m.getRiver(i, j) == 0){
							if(random < 0.1){
								m.setTile(i, j, 1);
							}else if(random < 0.2){
								m.setTile(i, j, 3);
							}else if(random < 0.3){
								m.setTile(i, j, 5);
							}
						}else{
							
						}
					}else if(m.getTile(i, j) == 7){
						double random = Math.random();
						if(random < 0.1){
							m.setTile(i, j, 1);
						}else if(random < 0.2){
							m.setTile(i, j, 2);
						}else if(random < 0.3){
							m.setTile(i, j, 4);
						}
					}else if(m.getTile(i, j) == 8){
						double random = Math.random();
						if(random < 0.1){
							m.setTile(i, j, 5);
						}
					}else if(m.getTile(i, j) == 9){
						double random = Math.random();
						if(random < 0.1){
							m.setTile(i, j, 5);
						}
					}else if(m.getTile(i, j) == 10){
						double random = Math.random();
						if(random < 0.1){
							m.setTile(i, j, 3);
						}
					}else if(m.getTile(i, j) == 11){
						double random = Math.random();
						if(random < 0.1){
							m.setTile(i, j, 3);
						}
					}else{
						
					}
				}
			}
		}
		
		//Generate offshoots
		for(int i = 0; i < m.WIDTH; i++){
			for(int j = 0; j < m.HEIGHT; j++){
				if(m.hasAdjacentConnected(i, j) && m.getRiver(i, j) == 1){
					m.setTile(i, j, 6);
				}
			}
		}
		
		for(int i = 0; i < m.WIDTH; i++){
			for(int j = 0; j < m.HEIGHT; j++){
				if(m.hasAdjacentConnected(i, j) && m.getRiver(i, j) == 1){
					m.setTile(i, j, 6);
				}
			}
		}
		
		//Fill town.
		while(m.hasOpenConnections()){
			for(int i = 0; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					if(m.hasAdjacentConnected(i, j) && m.getTile(i, j) == 0){
						boolean[] allowed = m.getAllowedTilesNoWater(i, j);
						int[] weights = new int[allowed.length];
						for(int k = 0; k < allowed.length; k++){
							if(allowed[k]){
								weights[k] = 1;
							}else{
								weights[k] = 0;
							}
						}
						
						int sum = 0;
						
						for(int k = 0; k < weights.length; k++){
							sum = sum + weights[k];
						}
						
						double random = Math.random();
						
						random = random * sum;
						
						boolean notChosen = true;
						for(int k = 0; k < weights.length; k++){
							random = random - weights[k];
							if(random < 0 && notChosen == true){
								m.setTile(i, j, k);
								notChosen = false;
							}
						}
					}
				}
			}
		}
		
		if(m.hasOpenConnections()){
			System.out.println("This is a problem map!");
		}
		
		m.fillZeroes();
	}

}
