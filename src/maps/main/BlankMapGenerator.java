package maps.main;

public class BlankMapGenerator extends MapGenerator{

	
	
	@Override
	public void generateMap(ArkhamMap m) {
		for(int i = 0; i < m.WIDTH; i++){
			for(int j = 0; j < m.HEIGHT; j++){
				m.setTile(i, j, 16);
			}
		}
	}
}
