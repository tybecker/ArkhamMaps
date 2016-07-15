package maps.main;



public class MapGenerator1 extends MapGenerator{

	@Override
	public void generateMap(ArkhamMap m) {
		
		m.reset();
		
		boolean incomplete = true;
		
		m.setTile(14, 9, 1);
		
		while(m.hasUndefined() && incomplete){
			
			//System.out.println("Working1");
			
			incomplete = false;
			
			for(int i = 0; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					//System.out.println("Working2a!");
					if(m.getTile(i, j) == 0 && m.hasAdjacentConnected(i, j)){
						incomplete = true;
						m.setTile(i, j, -1);
						//System.out.println("Working2");
					}
				}
			}
			
			//System.out.println("Working3");
			
			for(int i = 0; i < m.WIDTH; i++){
				for(int j = 0; j < m.HEIGHT; j++){
					if(m.getTile(i, j) == -1){
						boolean[] allowed = m.getAllowedTiles(i, j);
						int sum = 0;
						for(int n = 0; n < allowed.length; n++){
							if(allowed[n]){
								sum = sum + 1;
							}
						}
						double choosing = Math.random();
						choosing = choosing * sum;
						
						int chosenTile = 1;
						for(int n = 0; n < allowed.length; n++){
							if(allowed[n]){
								choosing = choosing - 1;
							}
							if(choosing < 0){
								chosenTile = n;
								choosing = 100;
							}
						}
						m.setTile(i, j, chosenTile);
					}
				}
			}
		}
		
		//System.out.println("Working 4");
		
		//m.fillZeroes();
	}
}
