package maps.main;

public class MapGenerator3 extends MapGenerator{

	@Override
	public void generateMap(ArkhamMap m) {
		m.reset();
		
		m.setTile(14, 9, 1);
		
		while(m.hasOpenConnections()){
			for(int i = 0; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					if(m.getTile(i, j) == 0 && m.hasAdjacentConnected(i, j)){
						boolean[] allowed = m.getAllowedTiles(i, j);
						
						int[] chances = new int[allowed.length];
						
						for(int k = 0; k < allowed.length; k++){
							if(allowed[k]){
								chances[k] = 1;
							}else{
								chances[k] = 0;
							}
						}
						
						if(m.hasAdjacentConnectedIntersection(i, j)){
							chances[6] = chances[6] * 9;
							chances[7] = chances[7] * 9;
						}
						
						int sumProbability = 0;
						for(int k = 0; k < chances.length; k++){
							sumProbability = sumProbability + chances[k];
						}
						
						double randomNumber = Math.random() * sumProbability;
						
						int tileType = 1;
						
						for(int k = 0; k < chances.length; k++){
							randomNumber = randomNumber - chances[k];
							if(randomNumber < 0){
								tileType = k;
								randomNumber = 1000;
							}
						}
						m.setTile(i, j, tileType);
					}
				}
			}
		}
		
	}

}
