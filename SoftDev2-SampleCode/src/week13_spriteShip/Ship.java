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
	double angle=3.15, angleV=0;
	
	double maxV = 5;
	double maxAngleV = .1;
	
	int size = 160;
	int imageSize = 10;
	int imageNumber= 0;
	boolean go= false;
	
	Image image;
	
	static Image images[] = getImages();
	static Image[] getImages(){
		try {
			BufferedImage testImage = ImageIO.read(new File("cars.png"));
			Image rawImage[] = ImageHelper.getSubImages(testImage, 4, 4);
			Image goodImage[] = new Image[16];
			goodImage[0] = rawImage[3];
			goodImage[1] = rawImage[2];
			goodImage[2] = rawImage[1];
			goodImage[3] = rawImage[0];
			goodImage[4] = rawImage[15];
			goodImage[5] = rawImage[14];
			goodImage[6] = rawImage[13];
			goodImage[7] = rawImage[12];
			goodImage[8] = rawImage[11];
			goodImage[9] = rawImage[10];
			goodImage[10] = rawImage[9];
			goodImage[11] = rawImage[8];
			goodImage[12] = rawImage[7];
			goodImage[13] = rawImage[6];
			goodImage[14] = rawImage[5];
			goodImage[15] = rawImage[4];
			
			
			return goodImage;
			
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
		angle += angleV;
		if (angle <0){
			angle = (2*Math.PI) + angle;
		}
		if (go){
			vx = this.maxV * Math.cos(angle);
			vy = this.maxV * Math.sin(angle);
		}else{
			vx =0;
			vy=0;
		}
		//System.out.println("angle" + angle+" x:"+vx+" vy:"+vy);
		x+=vx;
		y+=vy;
		imageNumber = Math.round((float) (((angle/(2*Math.PI))*16)));
		
		//System.out.println(imageNumber);
		imageNumber %=images.length;

	}
	public void turnLeft(boolean yes){
		if (yes){
			this.angleV = -this.maxAngleV;
		}else{
			this.angleV = 0;
		}
	}
	public void turnRight(boolean yes){
		if (yes){
			this.angleV = +this.maxAngleV;
		}else{
			this.angleV = 0;
		}
	}
	public void accelerate(boolean yes){
		go = yes;
	}

}
