
public class Moving extends Thread{
	
	Tetris obj = new Tetris();
	ControlPieces cp = new ControlPieces(obj);
	Pieces p = new Pieces();
	int H = obj.board.block.getHeight();
	
	public void runControl() {
		obj.addKeyListener(cp);
	}
	
	public void run() {
		while(true) {
			try {
				if((H+obj.board.block.getY()) != 14) {
					obj.board.moveBlockDown(); 
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


