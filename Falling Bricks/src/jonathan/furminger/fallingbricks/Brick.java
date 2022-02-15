package jonathan.furminger.fallingbricks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Brick {
	
	public static final int TILE_SIZE = 30;
	
	protected int x;
	protected int y;
	
	public Brick(int row, int col) {
		x = TILE_SIZE * (col - getNumberOfColumns() / 2);
		y = row * TILE_SIZE;
	}

	public void moveLeft() {
		x -= TILE_SIZE;
	}
	
	public void moveRight() {
		x += TILE_SIZE;
	}
	
	public int getColumn() {
		int col = x / TILE_SIZE;
		return col;
	}
	
	public int getRow() {
		// round up to the next row
		int row = (y + TILE_SIZE - 1) / TILE_SIZE;
		return row;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract int getNumberOfRows();
	
	public abstract int getNumberOfColumns();
	
	public abstract void rotateLeft();
	
	public abstract void rotateRight();
	
	public abstract boolean hasTileAt(int row, int col);
	
	public abstract BufferedImage getTileImage();
}
