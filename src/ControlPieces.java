import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControlPieces implements KeyListener {
	boolean right, left, allDown, space;
	Tetris obj;
	
	ControlPieces(Tetris obj) {
		this.obj = obj;
	}
	
	
	public boolean checkRight() {
		if(obj.board.block.getX()== 8) {return false;}
		return true;
	}
	
	
	public boolean checkLeft() {
		if(obj.board.block.getX()==0) { return false; }
		return true;
	}
	
	public boolean checkDown() {
		if(13-obj.board.block.getY()>5) { 
			return false; 
		}
		return true;
	}
	// => this returns true ==> we've reached the bottom line
	// => this returns false ==> we haven't reached the bottom line 
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			allDown = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)  {
			space = true;
		}
		// working
		if(right && checkRight() &&  (!(checkDown())) ) { 
			obj.board.moveBlockRight();
		}
		// working
		if(left && checkLeft() && (!(checkDown()))) {
				obj.board.moveBlockLeft();
		}
		// not working properly
		if(allDown) {
			if(!checkDown()) {
				obj.board.moveBlockAllDown();
			}
		}
		
		if(space) {      
//			obj.board.rotateBlock();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			allDown = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = false;
		}
		
	}
}
