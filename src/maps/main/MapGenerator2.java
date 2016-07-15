package maps.main;

public class MapGenerator2 extends MapGenerator{

	//This is just a deterministic generator in order to determine that the pieces
	//are in fact being drawn correctly, and that any weirdness in alg1 is not the
	//fault of the draw function.
	
	@Override
	public void generateMap(ArkhamMap m) {
		
		m.setTile(14, 9, 1);
		m.setTile(14, 10, 6);
		m.setTile(14, 11, 8);
		m.setTile(15, 11, 15);
		m.setTile(15, 9, 15);
		m.setTile(13, 9, 7);
		m.setTile(12, 9, 13);
		m.setTile(14, 8, 6);
		m.setTile(14, 7, 2);
		m.setTile(13, 7, 13);
		m.setTile(15, 7, 15);
	}

}
