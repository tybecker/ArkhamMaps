package maps.main;

public class MapGenerator7 extends MapGenerator{

	@Override
	public void generateMap(ArkhamMap m) {
		int tilesLaid = 0;
		int timesTried = 0;
		while(tilesLaid < 100 || tilesLaid > 115){
			tilesLaid = 0;
			m.reset();
			
			//Bounded Weighted Generator w/ Trunk road.
			
			//Step 1: The river
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
			
			
			//Next, generate the trunk road.  This time, it's going to continue until some
			//specific conditions are met.
			for(int i = 0; i < m.HEIGHT; i++){
				m.setTile(14, i, 6);
			}
			
			int mainEastRoad = 0;
			int eastRoadStart = 0;
			if(m.getRiver(14, 9) == 0 && m.getRiver(15, 9) == 0){
				m.setTile(14, 9, 5);
				mainEastRoad = 9;
				eastRoadStart = 9;
			}else{
				m.setTile(14, 6, 5);
				mainEastRoad = 6;
				eastRoadStart = 6;
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
			
			//Here's where we start generating offshoots.  We're going to keep going here until we've
			//generated at least some for each quadrant, but no more than a few.  Let's say 1 - 4 per quadrant.
			
			int upperLeft = 3;
			
			int upperRight = 3;
			
			int lowerLeft = 3;
			
			int lowerRight = 3;
			
			while(upperLeft == 3){
				for(int i = 0; i < eastRoadStart && upperLeft > 0; i++){
					if(m.getTile(14, i) == 6 && !m.hasAdjacentIntersection(14, i) && m.getRiver(14, i) == 0 && m.getRiver(13, i) == 0){
						if(Math.random() < 0.4){
							m.setTile(14, i, 3);
							upperLeft--;
						}
					}
				}
			}
			
			while(upperRight == 3 || (Math.random() < 0.66 && upperRight == 2) || (Math.random() < 0.33 && upperRight == 1)){
				boolean roadPicked = false;
				if(Math.random() < 0.5){
					for(int i = 0; i < eastRoadStart && !roadPicked; i++){
						if(!m.hasAdjacentIntersection(14, i) && m.getRiver(14, i) == 0 && m.getRiver(15, i) == 0 && Math.random() < 0.3){
							if(m.getTile(14, i) == 6){
								m.setTile(14, i, 5);
							}else if(m.getTile(14, i) == 3){
								m.setTile(14, i, 1);
							}
							roadPicked = true;
							upperRight--;
						}
					}
				}else{
					int eastRoadHeight = eastRoadStart;
					for(int i = 15; i < m.WIDTH && !roadPicked; i++){
						if(m.getTile(i, eastRoadHeight) == 7){
							if(!m.hasAdjacentIntersection(i, eastRoadHeight) && Math.random() < 0.3){
								m.setTile(i, eastRoadHeight, 4);
								roadPicked = true;
								upperRight--;
							}
						}else if(m.getTile(i, eastRoadHeight) == 10){
							if(!m.hasAdjacentIntersection(i, eastRoadHeight) && Math.random() < 0.3){
								m.setTile(i, eastRoadHeight, 3);
								roadPicked = true;
								upperRight--;
							}
							eastRoadHeight++;
						}else if(m.getTile(i, eastRoadHeight) == 11){
							if(!m.hasAdjacentIntersection(i, eastRoadHeight) && Math.random() < 0.3){
								m.setTile(i, eastRoadHeight - 1, 5);
								roadPicked = true;
								upperRight--;
							}
							eastRoadHeight--;
						}
					}
				}
			}
			
			while(lowerLeft == 3){
				for(int i = eastRoadStart; i < m.HEIGHT; i++){
					if(!m.hasAdjacentIntersection(14, i) && Math.random() < 0.3 && lowerLeft > 0){
						if(m.getTile(14, i) == 6 && m.getRiver(14, i) == 0 && m.getRiver(13, i) == 0){
							m.setTile(14, i, 3);
							lowerLeft--;
						}
					}
				}
			}
			
			while(lowerRight == 3 || (Math.random() < 0.66 && lowerRight == 2) || (Math.random() < 0.33 && lowerRight == 1)){
				if(Math.random() < 0.5){
					int eastRoadHeight = eastRoadStart;
					for(int i = 15; i < m.WIDTH && lowerRight > 0; i++){
						if(m.getTile(i, eastRoadHeight) == 7){
							if(!m.hasAdjacentIntersection(i, eastRoadHeight) && Math.random() < 0.3 && m.getRiver(i, eastRoadHeight) == 0){
								m.setTile(i, eastRoadHeight, 2);
								lowerRight--;
							}
						}else if(m.getTile(i, eastRoadHeight) == 10){
							if(!m.hasAdjacentIntersection(i, eastRoadHeight - 1) && Math.random() < 0.3 && m.getRiver(i, eastRoadHeight) == 0){
								m.setTile(i, eastRoadHeight + 1, 5);
								lowerRight--;
							}
							eastRoadHeight++;
						}else if(m.getTile(i, eastRoadHeight) == 11){
							if(!m.hasAdjacentIntersection(i, eastRoadStart) && Math.random() < 0.3 && m.getRiver(i, eastRoadHeight) == 0){
								m.setTile(i, eastRoadHeight, 3);
								lowerRight--;
							}
							eastRoadHeight--;
						}else if(m.getTile(i, eastRoadHeight) == 4){
							if(!m.hasAdjacentIntersection(i, eastRoadStart) && Math.random() < 0.3 && m.getRiver(i, eastRoadHeight) == 0){
								m.setTile(i, eastRoadHeight, 1);
								lowerRight--;
							}
						}else if(m.getTile(i, eastRoadHeight) == 3){
							if(!m.hasAdjacentIntersection(i, eastRoadStart) && Math.random() < 0.3 && m.getRiver(i, eastRoadHeight) == 0){
								m.setTile(i, eastRoadHeight + 1, 5);
								lowerRight--;
							}
						}
					}
				}else{
					for(int i = eastRoadStart; i < m.HEIGHT; i++){
						if(m.getTile(14, i) == 6){
							if(!m.hasAdjacentIntersection(14, i)  && Math.random() < 0.3 && m.getRiver(14, i) == 0 && m.getRiver(15, i) == 0){
								m.setTile(14, i, 5);
								lowerRight--;
							}
						}else if(m.getTile(14, i) == 3){
							if(!m.hasAdjacentIntersection(14, i)  && Math.random() < 0.3 && m.getRiver(14, i) == 0 && m.getRiver(15, i) == 0){
								m.setTile(14, i, 1);
								lowerRight--;
							}
						}
					}
				}
			}
			
			//Fill in the bridges
			for(int i = 15; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					if(m.getRiver(i, j) == 1 && m.hasAdjacentConnected(i, j)){
						m.setTile(i, j, 6);
					}
				}
			}
			
			for(int i = 15; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					if(m.getRiver(i, j) == 1 && m.hasAdjacentConnected(i, j)){
						m.setTile(i, j, 6);
					}
				}
			}
			
			//Finally, fill in the bounded map.  Let's try 60 tiles first.
			
			int multiplierType = 140;
			while(m.hasOpenConnections()){
				for(int i = 0; i < m.WIDTH; i++){
					for(int j = 0; j < m.HEIGHT; j++){
						if(m.getTile(i, j) == 0){
							if(m.hasAdjacentConnected(i, j)){
								boolean[] allowed = m.getAllowedTilesNoWater(i, j);
								int[] weights = new int[allowed.length];
								for(int k = 0; k < allowed.length; k++){
									if(allowed[k]){
										weights[k] = 100;
									}else{
										weights[k] = 0;
									}
								}
								
								if(m.hasAdjacentIntersection(i, j)){
									for(int k = 0; k < weights.length; k++){
										if(k == 6 || k == 7 || k == 12 || k == 13 || k == 14 || k == 15){
											
										}else{
											weights[k] = weights[k]/5;
										}
									}
								}
								
								if(multiplierType > 110){
									for(int k = 0; k < weights.length; k++){
										if(k == 12 || k == 13 || k == 14 || k == 15){
											weights[k] = weights[k]/5;
										}else if(k == 6 || k == 7 || k == 8 || k == 9 || k == 10 || k == 11){
											weights[k] = weights[k]/2;
										}else{
											
										}
									}
								}else if(multiplierType > 40){
									
								}else{
									for(int k = 0; k < weights.length; k++){
										if(k == 1 || k == 2 || k == 3 || k == 4 || k == 5){
											weights[k] = weights[k]/5;
										}else if(k == 6 || k == 7 || k == 8 || k == 9 || k == 10 || k == 11){
											weights[k] = weights[k]/3;
										}
									}
								}
								
								int sum = 0;
								
								for(int k = 0; k < weights.length; k++){
									sum = sum + weights[k];
								}
								
								double random = Math.random() * sum;
								boolean tilePlaced = false;
								for(int k = 0; k < weights.length; k++){
									random = random - weights[k];
									if(random <= 0 && !tilePlaced){
										m.setTile(i, j, k);
										tilePlaced = true;
										multiplierType--;
										tilesLaid++;
									}
								}
							}
						}
					}
				}
			}
			
			m.fillZeroes();
			timesTried++;
		}
		System.out.println("Times tried: " + timesTried);
		System.out.println("Tiles Laid: " + tilesLaid);
	}
}
