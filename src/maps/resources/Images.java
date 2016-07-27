package maps.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] mapPieces;
	
	public static BufferedImage[] riverPieces;
	
	public static BufferedImage[] setPieces;
	
	public Images(){
		mapPieces = new BufferedImage[17];
		
		try{
			mapPieces[1] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street1.png"));
			mapPieces[2] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street2.png"));
			mapPieces[3] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street3.png"));
			mapPieces[4] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street4.png"));
			mapPieces[5] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street5.png"));
			mapPieces[6] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street6.png"));
			mapPieces[7] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street7.png"));
			mapPieces[8] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street8.png"));
			mapPieces[9] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street9.png"));
			mapPieces[10] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street10.png"));
			mapPieces[11] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street11.png"));
			mapPieces[12] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street12.png"));
			mapPieces[13] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street13.png"));
			mapPieces[14] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street14.png"));
			mapPieces[15] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street15.png"));
			mapPieces[16] = ImageIO.read(getClass().getResourceAsStream("/streetpieces/Street16.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		riverPieces = new BufferedImage[17];
		
		try{
			riverPieces[1] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River1.png"));
			riverPieces[2] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River2.png"));
			riverPieces[3] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River3.png"));
			riverPieces[4] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River4.png"));
			riverPieces[5] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River5.png"));
			riverPieces[6] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River6.png"));
			riverPieces[7] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River7.png"));
			riverPieces[8] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River8.png"));
			riverPieces[9] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River9.png"));
			riverPieces[10] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River10.png"));
			riverPieces[11] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River11.png"));
			riverPieces[12] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River12.png"));
			riverPieces[13] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River13.png"));
			riverPieces[14] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River14.png"));
			riverPieces[15] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River15.png"));
			riverPieces[16] = ImageIO.read(getClass().getResourceAsStream("/riverpieces/River16.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		setPieces = new BufferedImage[10];
		
		try{
			setPieces[1] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece1.png"));
			setPieces[2] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece2.png"));
			setPieces[3] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece3_2.png"));
			setPieces[4] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece3_7.png"));
			setPieces[5] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece4.png"));
			setPieces[6] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece5.png"));
			setPieces[7] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece6_5.png"));
			setPieces[8] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece6_6.png"));
			setPieces[9] = ImageIO.read(getClass().getResourceAsStream("/setpieces/Setpiece7.png"));
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
