import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	Model model;
	public KeyListener(Model m){
		this.model=m;
	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			model.setXDir(-model.getXDir());
		}

		if (key == KeyEvent.VK_RIGHT) {
			model.setXDir(model.getXDir());
		}

		if (key == KeyEvent.VK_UP) {
			model.setYDir(-model.getYDir());
		}

		if (key == KeyEvent.VK_DOWN) {
			model.setYDir(model.getYDir());
		}
		if (key == KeyEvent.VK_J) {
			model.setIsJumping(true);
		}
		if(key == KeyEvent.VK_F) {
			model.setIsFiring(true);
		}
	}
	
	//In the future this can make the image stop moving when the keys are released
	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
		}
		if (key == KeyEvent.VK_RIGHT) {
		}
		if (key == KeyEvent.VK_UP) {
		}
		if (key == KeyEvent.VK_DOWN) {
		}
	}
	

}
