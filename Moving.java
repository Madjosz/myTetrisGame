import javax.swing.SwingUtilities;

public class Moving extends Thread{
	
	Tetris obj = new Tetris();
	Pieces o = new Pieces();
	Tetris.Board ob = obj.new Board();

	public void run() {
		int a=0;
		while(a<3) {
//			ob.moveBlockDown();
			o.moveDown();
			obj.repaint();
			System.out.println(o.getY());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a++;
		}
	}
}


