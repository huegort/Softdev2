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
		for (int y= 0; y< numberOfRows;y++){
			for(int x = 0; x<numberOfColumns ;x++){
				images[count] = image.getSubimage((x*width),(y*height), width, height);
				count++;
			}
		}
		return images;
	}

}
