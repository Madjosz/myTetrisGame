import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;







public class Tetris extends JFrame{
	private static final long serialVersionUID = 1L;
	int spacing = 1;
    Board board;
	Tetris() {
		setUndecorated(true);
		JFrame frame = new JFrame();
		this.setSize(510,710);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	    board = new Board();
	    this.setContentPane(board);
	    this.setVisible(true); 
	}
	
	public class Board extends JPanel {
		private static final long serialVersionUID = 1L;
		
		Pieces tetrisPObj = new Pieces(Color.red, new int[][] {{0,1},{0,1},{1,1}}, 0,0);
		
		int tetros [][] = tetrisPObj.getShape();
		Color color = tetrisPObj.getColor();	
		int spacing = 1;
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0, 510, 710);
			g.setColor(Color.black);
			for(int i=0; i<10 ; i++) {
				for(int j=0; j<14 ; j++) {
					g.fillRect(spacing+i*51, spacing+j*51, 51-2*spacing, 51-2*spacing);
				}
			}
			// draw tetros
			g.setColor(Color.red);
			for(int i=0; i<tetrisPObj.getHeight(); i++) {
				for(int j=0; j<tetrisPObj.getWidth(); j++) {
					if( tetros[i][j] ==  1) {
						int x = spacing + (tetrisPObj.getX() + j)*51;
						int y = spacing + (tetrisPObj.getY() + i)*51;
//						g.fillRect(spacing+j*51, spacing+i*51, 51-2*spacing, 51-2*spacing);
						g.fillRect(x , y, 51-2*spacing, 51-2*spacing);
					}
				}
			}
		}
		
		// let's create movingBlock
		public void moveBlockDown() {
			tetrisPObj.moveDown();
			repaint();
		}
	}
}