package week08Canvas.ball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BallDisplay extends JPanel {

	Ball ball;
	int imageNumber =0;
	int count=0;
	int widthOfSprite = 10;
	int HeightOfSprite = 16;
	int rowY = 32;
	int rowX = 19;
	
	
	public BallDisplay(){
		ball = new Ball(100,50);
	}
	@Override
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		ball.draw((Graphics2D) g);
		
		try {
			BufferedImage testImage = ImageIO.read(new File("RPG_assets.png"));
			g2.drawImage(testImage, 10,10, null);
			
			//now walking
			g2.drawImage(testImage, 200, 100, 230, 130, rowX, rowY+ (HeightOfSprite * (imageNumber)), rowX+ widthOfSprite, rowY+(HeightOfSprite * (imageNumber+1)), null);
			 
			count++;
			if (count %10== 0){
				imageNumber = (imageNumber +1)%2;
				count =0;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
