import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetris extends JFrame {
	private static final long serialVersionUID = 1L;
	final int spacing = 1;
	final int gridHeight = 710;
	final int gridWidth = 510;
	final Board board;
	final JFrame frame;

	
	Tetris() {
		setUndecorated(true);
		frame = new JFrame();
		this.setSize(gridWidth, gridHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
	    
		
		board = new Board();
	    this.setContentPane(board);
	    this.setVisible(true); 
	    
	}
	
	public class Board extends JPanel {
		private static final long serialVersionUID = 1L;
		Pieces block = new Pieces(Color.blue, new int[][] {
				{1,1},
				{1,1}
		});
			
		
		
		int[][] tetros =block.getShape();
		Color color = block.getColor();
		
		
		
		public int[][] pickShape() {
			Random t = new Random();
			int rand = t.nextInt(1,7);
			switch(rand) {
				case 1:
					int[][] shape1 = { 
							{1,0}, 
							{1,0},
							{1,1}
					};
					return shape1;
				case 2:
					int[][] shape2 = { 
							{0,1}, 
							{0,1},
							{1,1}
					};
					return shape2;
				case 3:
					int[][] shape3 = { 
							{1,0}, 
							{1,1},
							{0,1}
					};
					return shape3;
				case 4:
					int[][] shape4 = { 
							{0,1}, 
							{1,1},
							{1,0}
					};
					return shape4;
				case 5:
					int[][] shape5 = { 
							{1,1}, 
							{1,1}
					};
					return shape5;
				case 6:
					int[][] shape6 = { 
							{0,1,0}, 
							{1,1,1},
					};
					return shape6;
				default:
					int[][] shape7 = { 
							{1,0}, 
							{1,0},
							{1,0},
							{1,0}
					};
					return shape7;
			}
		}
		
		
		public Color pickColor() {
			Random rand = new Random();
			int colorInt = rand.nextInt(1, 9);
			Color theChosen;
			
			switch(colorInt) {
				case 1:
					theChosen = Color.green;
					break;
				case 2:
					theChosen = Color.yellow;
					break;
				case 3:
					theChosen = Color.MAGENTA;
					break;
				case 4:
					theChosen = Color.white;
					break;
				case 5:
					theChosen = Color.pink;
					break;
				case 6:
					theChosen = Color.magenta;
					break;
				case 7:
					theChosen = Color.RED;
					break;
				case 8:
					theChosen = Color.WHITE;
					break;
				default:
					theChosen = Color.orange;
					break;
			}
			return theChosen; 
		}
		
		
		public void drawPiece(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0, gridWidth, gridHeight);
			g.setColor(Color.black);
			for(int i=0; i<10 ; i++) {
				for(int j=0; j<14 ; j++) {
					g.fillRect(spacing+i*51, spacing+j*51, 51-2*spacing, 51-2*spacing);
				}
			}
			// draw tetros
			g.setColor(color);
			for(int i=0; i<block.getHeight(); i++) {
				for(int j=0; j<block.getWidth(); j++) {
					if( tetros[i][j] ==  1) {
						int x = spacing + (block.getX() + j)*51;
						int y = spacing + (block.getY() + i)*51;
//						g.fillRect(spacing+j*51, spacing+i*51, 51-2*spacing, 51-2*spacing);
						g.fillRect(x , y, 51-2*spacing, 51-2*spacing);
					}
				}
			}
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawPiece(g);
		}
		
		// let's create movingBlock
		public void moveBlockDown() {
			block.moveDown();
			repaint();
		}
		public void moveBlockRight() {
			block.moveRight();
			repaint();
		}
		public void moveBlockLeft() {
			block.moveLeft();
			repaint();
		}
		public void moveBlockAllDown() {
			block.moveAllDown();
			repaint();
		}
		public void rotateBlock() {
			block.rotate();
			repaint();
		}
	}
}