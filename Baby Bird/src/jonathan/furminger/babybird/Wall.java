package jonathan.furminger.babybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import jonathan.furminger.mycommonmethods.FileIO;

public class Wall {
	private static final String WALL_IMAGE_FILE = "/wall.jpg";
	
	private static BufferedImage wallImage;
	private static int width = 72;
	private static int height = 600;
	private static final int CHANGE_X = -10;
	private static final int TOP_MIN = 100;
	private static final int TOP_MAX = 300;
	private static final int GAP_MIN = 100;
	private static final int GAP_MAX = 240;
	
	private int x = FlightPanel.WIDTH;
	private int bottomY;
	private int topHeight;
	private int bottomHeight;
	private BufferedImage topImage;
	private BufferedImage bottomImage;
	private Random rand = new Random();
	
	public Wall() {
		if(wallImage == null) {
			wallImage = FileIO.readImageFile(this, WALL_IMAGE_FILE);
			width = wallImage.getWidth();
			height = wallImage.getHeight();
		}
		
		int range = GAP_MAX - GAP_MIN;
		int pick = rand.nextInt(range);
		int gap = pick + GAP_MIN;
		
		range = TOP_MAX - TOP_MIN;
		pick = rand.nextInt(range);
		topHeight = pick + TOP_MIN;
		
		bottomY = topHeight + gap;
		bottomHeight = FlightPanel.HEIGHT - bottomY;
		
		topImage = wallImage.getSubimage(0, height - topHeight, width, topHeight);
		bottomImage = wallImage.getSubimage(0, 0, width, bottomHeight);
		
	}
	
	public void draw(Graphics g) {
		if(wallImage == null) {
			g.setColor(Color.CYAN);
			g.fillRect(x, 0, width, topHeight);
			g.fillRect(x, bottomY, width, bottomHeight);
		}
		else {
			g.drawImage(topImage, x, 0, null);
			g.drawImage(bottomImage, x, bottomY, null);
			
		}
	}
	
	public void move() {
		x+= CHANGE_X;
	}
	
	public boolean isPastWindowEdge() {
		int rightEdgeX = x + width;
		return rightEdgeX < 0;
	}
	
	public Rectangle getTopBounds() {
		Rectangle bounds = new Rectangle(x, 0, width, topHeight);
		return bounds;
	}
	
	public Rectangle getBottomBounds() {
		Rectangle bounds = new Rectangle(x, bottomY, width, bottomHeight);
		return bounds;
	}
	
}
