

import java.awt.Color;

public class Pieces {
		private Color color;
		private int[][] shape;
		private int x, y;
		
		
		Pieces(Color color, int shape[][], int x, int y) {
			this.color = color;
			this.shape = shape;
			this.x = x; 
			this.y = y; 
		}
		Pieces() {
			
		}
		
		public Color getColor() {
			return this.color;
		}
		
		public int[][] getShape() {
			return this.shape;
		}
		
		public int getHeight() {
			return this.shape.length;
		}
		public int getWidth() {
			return this.shape[0].length;
		}
		
		public int getX() {
			return this.x;
		}
		public int getY() {
			return this.y;
		}
		public void moveDown() { 
			this.y++; 
		}
		
		public void moveLeft() { 
			this.x--; 
		}
		
		
		public void moveRight() { 
			this.x++; 
		}
	}
