package ie.gmit.sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ImageHelper is a utility class created for the Software Development course in GMIT(Mayo Campus)
 * 
 * @author ABeatty
 *
 */

public class ImageHelper {
	public static Image[] getSubImages(BufferedImage image,int numberOfColumns, int numberOfRows ){
		Image images[] = new Image[numberOfColumns*numberOfRows]; 
		int width = image.getWidth(null)/numberOfColumns;
		int height = image.getHeight(null)/numberOfRows;
		int count = 0;
		for (int row= 0; row< numberOfRows;row++){
			for(int col = 0; col<numberOfColumns ;col++){
				images[count] = image.getSubimage((col*width),(row*height), width, height);
				count++;
			}
		}
		return images;
	}

}
