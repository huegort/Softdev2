package week13_spriteShip;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ie.gmit.sprites.ImageHelper;

public class Ship implements Actor {
	GameBoard gameBoard;
	double x, y;
	double vx=0,vy=0;
	double currentV=0;
	double angle=0, angleV=0;
	
	double maxV = 5;
	double maxAngleV = .1;
	
	int size = 160;
	int imageSize = 10;
	int imageNumber= 0;
	
	Image image;
	
	static Image images[] = getImages();
	static Image[] getImages(){
		try {
			BufferedImage testImage = ImageIO.read(new File("cars.png"));
			return ImageHelper.getSubImages(testImage, 4, 4);
			
			//BufferedImage testImage = ImageIO.read(new File("sprites/bird.png"));
			//return ImageHelper.getSubImages(testImage, 5, 3);
			
		} catch (IOException e) {
			throw new RuntimeException("could not laod image",e);
		}
	}
	
	public Ship(GameBoard gameBoard){
		this.gameBoard = gameBoard;
		this.x=0;
		this.y=0;
	}
	



	@Override
	public void draw(Graphics2D g2) {
		int marginTop = 50;
		int marginLeft = 0;
		int width = 219;
		int height = 212;
		
		g2.drawImage(images[imageNumber], (int)x,(int)y,(int)x+size,(int)y+size,0,0,images[imageNumber].getWidth(null),images[imageNumber].getHeight(null),null);
		//g2.drawImage(images[0], 0, 0, null);
		
		

	}

	@Override
	public void tick() {
		imageNumber++;
		//System.out.println(imageNumber);
		imageNumber %=images.length;

	}

}
