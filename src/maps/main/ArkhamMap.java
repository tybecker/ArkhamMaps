package maps.main;

import java.awt.Graphics;

import maps.resources.Images;

public class ArkhamMap {
	//The integer representation of the map grid.
	//		x
	//		0	1	2	3	4	5	6 ->
	//y	0	.	.	.	.	.	.	.
	//	1	.	.	.	.	.	.	.
	//	2	.	.	.	.	.	.	.
	//	3	.	.	.	.	.	.	.
	//	4	.	.	.	.	.	.	.
	//	5	.	.	.	.	.	.	.
	//	6	.	.	.	.	.	.	.
	//	|
	//	V
	
	//Size decreased due to me not having a particularly large screen.
	public final int WIDTH = 28;
	public final int HEIGHT = 19;
	
	//public final int WIDTH = 40;
	//public final int HEIGHT = 30;
	
	int[][] riverGrid = new int[WIDTH][HEIGHT];
	
	int[][] mapGrid = new int[WIDTH][HEIGHT];
	
	//For this grid, I'll list setpieces here:
	//	1	1	1	|	13	7	7	The house on the end of the street
	//	2	2	2	|	0	0	0	The park
	//	2	2	2	|	0	0	0
	//	2	2	2	|	0	0	0
	//	3	|	0	The Hotel
	//	3	|	7,2
	//	4	4	4	|	0	0	0	Miskatonic U
	//	4	4	4	|	0	0	0
	//	5	|	6	Market Road
	//	5	|	6
	//	5	|	3
	//	5	|	6
	//	5	|	6
	//	6	6	|	0	5,6	The pawn shop.
	//	7 	|	7	Charlotte's boutique.
	int[][] setPieceGrid = new int[WIDTH][HEIGHT];
	
	public ArkhamMap(){
		
	}
	
	public void draw(Graphics g, int xCoord, int yCoord){
		//g.drawImage(Images.pieces[8], xCoordinate, yCoordinate, 78, 78, null);
		
		for(int i = 0; i < mapGrid.length; i++){
			for(int j = 0; j < mapGrid[0].length; j++){
				if(riverGrid[i][j] == 1){
					g.drawImage(Images.riverPieces[mapGrid[i][j]], xCoord + (i * 30), yCoord + (j * 30), 30, 30, null);
				}else{
					g.drawImage(Images.mapPieces[mapGrid[i][j]], xCoord + (i * 30), yCoord + (j * 30), 30, 30, null);
				}
			}
		}
		
		boolean[] drawn = new boolean[10];
		
		for(int i = 0; i < drawn.length; i++){
			drawn[i] = false;
		}
		
		for(int i = 0; i < WIDTH; i++){
			for(int j = 0; j < HEIGHT; j++){
				if(setPieceGrid[i][j] != 0){
					if(drawn[setPieceGrid[i][j]] == false){
						if(setPieceGrid[i][j] == 1){
							g.drawImage(Images.setPieces[1], xCoord + (i * 30), yCoord + (j * 30), 90, 30, null);
						}else if(setPieceGrid[i][j] == 2){
							g.drawImage(Images.setPieces[2], xCoord + (i * 30), yCoord + (j * 30), 90, 90, null);
						}else if(setPieceGrid[i][j] == 3){
							if(mapGrid[i][j + 1] == 2){
								g.drawImage(Images.setPieces[3], xCoord + (i * 30), yCoord + (j * 30), 30, 60, null);
							}else if(mapGrid[i][j + 1] == 7){
								g.drawImage(Images.setPieces[4], xCoord + (i * 30), yCoord + (j * 30), 30, 60, null);
							}
						}else if(setPieceGrid[i][j] == 4){
							g.drawImage(Images.setPieces[5], xCoord + (i * 30), yCoord + (j * 30), 90, 60, null);
						}else if(setPieceGrid[i][j] == 5){
							g.drawImage(Images.setPieces[6], xCoord + (i * 30), yCoord + (j * 30), 30, 150, null);
						}else if(setPieceGrid[i][j] == 6){
							if(mapGrid[i + 1][j] == 5){
								g.drawImage(Images.setPieces[7], xCoord + (i * 30), yCoord + (j * 30), 60, 30, null);
							}else if(mapGrid[i + 1][j] == 6){
								g.drawImage(Images.setPieces[8], xCoord + (i * 30), yCoord + (j * 30), 60, 30, null);
							}
						}else if(setPieceGrid[i][j] == 7){
							g.drawImage(Images.setPieces[9], xCoord + (i * 30), yCoord + (j * 30), 30, 30, null);
						}else if(setPieceGrid[i][j] == 8){
							
						}else if(setPieceGrid[i][j] == 9){
							
						}
						drawn[setPieceGrid[i][j]] = true;
					}
				}
			}
		}
	}
	
	public int getTile(int x, int y){
		if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
			return mapGrid[x][y];
		}
		return 16;
	}
	
	public void setTile(int x, int y, int n){
		mapGrid[x][y] = n;
	}
	
	public boolean[] getAllowedTiles(int x, int y){
		boolean[] allowedTiles = new boolean[17];
		
		for(int i = 1; i < allowedTiles.length; i++){
			allowedTiles[i] = true;
		}
		
		if(y > 0){
			if(mapGrid[x][y - 1] == 0){
				
			}else if(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 5 || mapGrid[x][y - 1] == 6 || mapGrid[x][y - 1] == 9 || mapGrid[x][y - 1] == 10 || mapGrid[x][y - 1] == 14){
				allowedTiles[2] = false;
				allowedTiles[7] = false;
				allowedTiles[9] = false;
				allowedTiles[10] = false;
				allowedTiles[13] = false;
				allowedTiles[14] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[8] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[3] = false;
			allowedTiles[4] = false;
			allowedTiles[5] = false;
			allowedTiles[6] = false;
			allowedTiles[8] = false;
			allowedTiles[11] = false;
			allowedTiles[12] = false;
		}
		
		if(x < WIDTH - 1){
			if(mapGrid[x + 1][y] == 0){
				
			}else if(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4 || mapGrid[x + 1][y] == 7 || mapGrid[x + 1][y] == 10 || mapGrid[x + 1][y] == 11 || mapGrid[x + 1][y] == 15){
				allowedTiles[3] = false;
				allowedTiles[6] = false;
				allowedTiles[10] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
				allowedTiles[14] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[7] = false;
				allowedTiles[8] = false;
				allowedTiles[9] = false;
				allowedTiles[13] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[4] = false;
			allowedTiles[5] = false;
			allowedTiles[7] = false;
			allowedTiles[8] = false;
			allowedTiles[9] = false;
			allowedTiles[13] = false;
		}
		
		if(y < HEIGHT - 1){
			if(mapGrid[x][y + 1] == 0){
				
			}else if(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5 || mapGrid[x][y + 1] == 6 || mapGrid[x][y + 1] == 8 || mapGrid[x][y + 1] == 11 || mapGrid[x][y + 1] == 12){
				allowedTiles[4] = false;
				allowedTiles[7] = false;
				allowedTiles[8] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
				allowedTiles[13] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[9] = false;
				allowedTiles[10] = false;
				allowedTiles[14] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[3] = false;
			allowedTiles[5] = false;
			allowedTiles[6] = false;
			allowedTiles[9] = false;
			allowedTiles[10] = false;
			allowedTiles[14] = false;
		}
		
		if(x > 0){
			if(mapGrid[x - 1][y] == 0){
				
			}else if(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5 || mapGrid[x - 1][y] == 7 || mapGrid[x - 1][y] == 8 || mapGrid[x - 1][y] == 9 || mapGrid[x - 1][y] == 13){
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[8] = false;
				allowedTiles[9] = false;
				allowedTiles[12] = false;
				allowedTiles[13] = false;
				allowedTiles[14] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[7] = false;
				allowedTiles[10] = false;
				allowedTiles[11] = false;
				allowedTiles[15] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[3] = false;
			allowedTiles[4] = false;
			allowedTiles[7] = false;
			allowedTiles[10] = false;
			allowedTiles[11] = false;
			allowedTiles[15] = false;
		}
		
		return allowedTiles;
	}
	
	public boolean[] getAllowedTilesNoWater(int x, int y){
		boolean[] allowedTiles = new boolean[17];
		
		for(int i = 1; i < allowedTiles.length; i++){
			allowedTiles[i] = true;
		}
		
		if(y > 0){
			if(mapGrid[x][y - 1] == 0){
				
			}else if(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 5 || mapGrid[x][y - 1] == 6 || mapGrid[x][y - 1] == 9 || mapGrid[x][y - 1] == 10 || mapGrid[x][y - 1] == 14){
				allowedTiles[2] = false;
				allowedTiles[7] = false;
				allowedTiles[9] = false;
				allowedTiles[10] = false;
				allowedTiles[13] = false;
				allowedTiles[14] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[8] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[3] = false;
			allowedTiles[4] = false;
			allowedTiles[5] = false;
			allowedTiles[6] = false;
			allowedTiles[8] = false;
			allowedTiles[11] = false;
			allowedTiles[12] = false;
		}
		
		if(x < WIDTH - 1){
			if(mapGrid[x + 1][y] == 0){
				
			}else if(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4 || mapGrid[x + 1][y] == 7 || mapGrid[x + 1][y] == 10 || mapGrid[x + 1][y] == 11 || mapGrid[x + 1][y] == 15){
				allowedTiles[3] = false;
				allowedTiles[6] = false;
				allowedTiles[10] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
				allowedTiles[14] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[7] = false;
				allowedTiles[8] = false;
				allowedTiles[9] = false;
				allowedTiles[13] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[4] = false;
			allowedTiles[5] = false;
			allowedTiles[7] = false;
			allowedTiles[8] = false;
			allowedTiles[9] = false;
			allowedTiles[13] = false;
		}
		
		if(y < HEIGHT - 1){
			if(mapGrid[x][y + 1] == 0){
				
			}else if(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5 || mapGrid[x][y + 1] == 6 || mapGrid[x][y + 1] == 8 || mapGrid[x][y + 1] == 11 || mapGrid[x][y + 1] == 12){
				allowedTiles[4] = false;
				allowedTiles[7] = false;
				allowedTiles[8] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
				allowedTiles[13] = false;
				allowedTiles[15] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[9] = false;
				allowedTiles[10] = false;
				allowedTiles[14] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[3] = false;
			allowedTiles[5] = false;
			allowedTiles[6] = false;
			allowedTiles[9] = false;
			allowedTiles[10] = false;
			allowedTiles[14] = false;
		}
		
		if(x > 0){
			if(mapGrid[x - 1][y] == 0){
				
			}else if(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5 || mapGrid[x - 1][y] == 7 || mapGrid[x - 1][y] == 8 || mapGrid[x - 1][y] == 9 || mapGrid[x - 1][y] == 13){
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[8] = false;
				allowedTiles[9] = false;
				allowedTiles[12] = false;
				allowedTiles[13] = false;
				allowedTiles[14] = false;
				allowedTiles[16] = false;
			}else{
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[7] = false;
				allowedTiles[10] = false;
				allowedTiles[11] = false;
				allowedTiles[15] = false;
			}
		}else{
			allowedTiles[1] = false;
			allowedTiles[2] = false;
			allowedTiles[3] = false;
			allowedTiles[4] = false;
			allowedTiles[7] = false;
			allowedTiles[10] = false;
			allowedTiles[11] = false;
			allowedTiles[15] = false;
		}
		
		//Now check for rivers.
		if(x > 0){
			if(riverGrid[x - 1][y] == 1 && !(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5 || mapGrid[x - 1][y] == 7 || mapGrid[x - 1][y] == 8 || mapGrid[x - 1][y] == 9 || mapGrid[x - 1][y] == 13)){
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[7] = false;
				allowedTiles[10] = false;
				allowedTiles[11] = false;
				allowedTiles[15] = false;
			}
		}
		
		if(x < WIDTH - 1){
			if(riverGrid[x + 1][y] == 1 && !(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4 || mapGrid[x + 1][y] == 7 || mapGrid[x + 1][y] == 10 || mapGrid[x + 1][y] == 11 || mapGrid[x + 1][y] == 15)){
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[7] = false;
				allowedTiles[8] = false;
				allowedTiles[9] = false;
				allowedTiles[13] = false;
			}
		}
		
		if(y > 0){
			if(riverGrid[x][y - 1] == 1 && !(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 5 || mapGrid[x][y - 1] == 6 || mapGrid[x][y - 1] == 9 || mapGrid[x][y - 1] == 10 || mapGrid[x][y - 1] == 14)){
				allowedTiles[1] = false;
				allowedTiles[3] = false;
				allowedTiles[4] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[8] = false;
				allowedTiles[11] = false;
				allowedTiles[12] = false;
			}
		}
		
		if(y < HEIGHT - 1){
			if(riverGrid[x][y + 1] == 1 && !(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5 || mapGrid[x][y + 1] == 6 || mapGrid[x][y + 1] == 8 || mapGrid[x][y + 1] == 11 || mapGrid[x][y + 1] == 12)){
				allowedTiles[1] = false;
				allowedTiles[2] = false;
				allowedTiles[3] = false;
				allowedTiles[5] = false;
				allowedTiles[6] = false;
				allowedTiles[9] = false;
				allowedTiles[10] = false;
				allowedTiles[14] = false;
			}
		}
		
		return allowedTiles;
	}
	
	public boolean hasAdjacentConnectedIntersection(int x, int y){
		boolean adjacent = false;
		
		if(y > 0){
			if(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 5){
				adjacent = true;
			}
		}
		
		if(x < WIDTH - 1){
			if(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4){
				adjacent = true;
			}
		}
		
		if(y < HEIGHT - 1){
			if(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5){
				adjacent = true;
			}
		}
		
		if(x > 0){
			if(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5){
				adjacent = true;
			}
		}
		
		return adjacent;
	}
	
	public boolean hasAdjacentIntersection(int x, int y){
			boolean adjacent = false;
		
		if(y > 0){
			if(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 4 || mapGrid[x][y - 1] == 5){
				adjacent = true;
			}
		}
		
		if(x < WIDTH - 1){
			if(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4 || mapGrid[x + 1][y] == 5){
				adjacent = true;
			}
		}
		
		if(y < HEIGHT - 1){
			if(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 2 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5){
				adjacent = true;
			}
		}
		
		if(x > 0){
			if(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x-1][y] == 3 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5){
				adjacent = true;
			}
		}
		
		return adjacent;
	}
	
	public void reset(){
		for(int i = 0; i < mapGrid.length; i++){
			for(int j = 0; j < mapGrid[0].length; j++){
				mapGrid[i][j] = 0;
				riverGrid[i][j] = 0;
				setPieceGrid[i][j] = 0;
			}
		}
	}
	
	public boolean hasUndefined(){
		for(int i = 0; i < WIDTH; i++){
			for(int j = 0; j < HEIGHT; j++){
				if(mapGrid[i][j] == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hasAdjacentConnected(int x, int y){
		if(x > 0){
			if(mapGrid[x - 1][y] == 1 || mapGrid[x - 1][y] == 2 || mapGrid[x - 1][y] == 4 || mapGrid[x - 1][y] == 5 || mapGrid[x - 1][y] == 7 || mapGrid[x - 1][y] == 8 || mapGrid[x - 1][y] == 9 || mapGrid[x - 1][y] == 13){
				return true;
			}
		}
		
		if(y < HEIGHT - 1){
			if(mapGrid[x][y + 1] == 1 || mapGrid[x][y + 1] == 3 || mapGrid[x][y + 1] == 4 || mapGrid[x][y + 1] == 5 || mapGrid[x][y + 1] == 6 || mapGrid[x][y + 1] == 8 || mapGrid[x][y + 1] == 11 || mapGrid[x][y + 1] == 12){
				return true;
			}
		}
		
		if(x < WIDTH - 1){
			if(mapGrid[x + 1][y] == 1 || mapGrid[x + 1][y] == 2 || mapGrid[x + 1][y] == 3 || mapGrid[x + 1][y] == 4 || mapGrid[x + 1][y] == 7 || mapGrid[x + 1][y] == 10 || mapGrid[x + 1][y] == 11 || mapGrid[x + 1][y] == 15){
				return true;
			}
		}
		
		if(y > 0){
			if(mapGrid[x][y - 1] == 1 || mapGrid[x][y - 1] == 2 || mapGrid[x][y - 1] == 3 || mapGrid[x][y - 1] == 5 || mapGrid[x][y - 1] == 6 || mapGrid[x][y - 1] == 9 || mapGrid[x][y - 1] == 10 || mapGrid[x][y - 1] == 14){
				return true;
			}
		}
		return false;
	}
	
	public void fillZeroes(){
		for(int i = 0; i < WIDTH; i++){
			for(int j = 0; j < HEIGHT; j++){
				if(mapGrid[i][j] == 0){
					mapGrid[i][j] = 16;
				}
			}
		}
	}
	
	public boolean hasOpenConnections(){
		
		for(int i = 0; i < WIDTH; i++){
			for(int j = 0; j < HEIGHT; j++){
				if(mapGrid[i][j] == 0 && hasAdjacentConnected(i, j)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void setRiver(int x, int y, int z){
		riverGrid[x][y] = z;
	}
	
	public int getRiver(int x, int y){
		if(x > 0 && x < WIDTH && y > 0 && y < HEIGHT){
			return riverGrid[x][y];
		}
		return 0;
	}
	
	public void setSetPiece(int x, int y, int z){
		if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
			setPieceGrid[x][y] = z;
		}else{
			
		}
	}
	
	public int getSetPiece(int x, int y){
		if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
			return setPieceGrid[x][y];
		}else{
			return 0;
		}
	}
	
	//Planned methods:
	//public boolean hasAdjacentCorner(int x, int y)
	//public boolean hasAdjacentConnected(int x, int y)
	//public boolean hasAdjacentConnectedCorner(int x, int y)
	//public boolean hasAdjacentConnectedCornerOrIntersection(int x, int y)
	//public boolean hasAdjacentCornerOrIntersection(int x, int y)
	//And then the counting logic:
	//public int AdjacentIntersectionCount
	//Etc...
}
