import javax.swing.SwingUtilities;

public class Moving extends Thread{
	
	Tetris obj = new Tetris();

	public void run() {
		int a=0;
		while(a<3) {
			obj.board.moveBlockDown();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a++;
		}
	}
}


