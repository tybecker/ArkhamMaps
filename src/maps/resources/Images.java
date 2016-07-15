package maps.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] mapPieces;
	
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
	}

}
