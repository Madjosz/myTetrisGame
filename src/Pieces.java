

import java.awt.Color;

public class Pieces {
		private Color color;
		private int[][] shape;
		private int x, y;
		
		private int[][][] shapes;
		private int currentRotation = 0;//
		
		public Pieces block;
		
		Pieces(Color color, int[][] shape) {
			this.color = color;
			this.shape = shape;
//			pickRotationShape();
//			this.shape = shapes[currentRotation];
			this.x = (10-getWidth()) / 2;
			this.y = -getHeight();
		}
		
		Pieces() {
		}
		
		
		
		public void pickRotationShape() {
			shapes = new int[4][][];
			
			for(int i=0; i<4; i++) {
				int r = this.shape[0].length;
				int c = this.shape.length;
				shapes[i] = new int[r][c];
				for(int y = 0; y < r; y++) {
					for(int x = 0; x < c; x++) {
						try {
							shapes[i][y][x] = shape[c-x-1][y];
						}catch(Exception e) {
							System.out.println("err");
						}
					}
				}
				shape = shapes[i];
			}
		}
		
		
		
		public Color getColor() {
			return this.color;
		}
		
		public int[][] getShape() {
			return this.shape;
		}
		
		
		public int getHeight() {
			return shape.length; // rows
		}
	

		public int getWidth() {
			return shape[0].length; // columns
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public void moveDown() { 
			y++; 
		}
		public void moveAllDown() {
			y+=4;
		}
		public void moveLeft() { 
			x--; 
		}
		public void moveRight() { 
			x++; 
		}
		public void rotate() {//
			currentRotation++;
			if(currentRotation > 3) {
				currentRotation=0;
			}
			this.shape = shapes[currentRotation];
		}
	}
