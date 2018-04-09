import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

class Model extends KeyAdapter{
	private int width, height, imageWidth, imageHeight;
	private int x=0;
	private int y=0;
	private int xDir = 1;
	private int yDir = 1;
	private final int xIncr = 8;
	private final int yIncr = 2;
	private boolean isMoving = true;
	private boolean isJumping = false;
	private OrcImage action = OrcImage.IDLE_S;
	private Direction orcDir = Direction.SOUTHEAST;

	Model(int width, int height, int imageWidth, int imageHeight){
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public OrcImage getAction() {
		return action;
	}
	public void setAction(OrcImage action) {
		this.action=action;
	}
	public int[] getDirect(){
		int[] dir = {this.xDir, this.yDir};
		return dir;
	}
	public boolean isMoving() {
		return isMoving;
	}
	public void toggleMoving() {
		this.isMoving = !this.isMoving;
	}
	public boolean isJumping() {
		return isJumping;
	}
	public void toggleJumping() {
		this.isJumping = !this.isJumping;
	}
	
	//updates direction based on key pressed
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			xDir = -1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			xDir = 1;
		}

		if (key == KeyEvent.VK_UP) {
			yDir = -1;
		}

		if (key == KeyEvent.VK_DOWN) {
			yDir = 1;
		}
		if (key == KeyEvent.VK_J) {
			isJumping = true;
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
	
	
	private int jumpStart=-1;
	public void updateLocationAndDirection(int tick_counter){
		//if(!isMoving) return;
		//jump action needs to pre-empt like everything else...
		
		if(!this.isMoving) {
			this.action=OrcImage.idle(this.orcDir);
			return;
		} else {
			this.action = OrcImage.forward(this.orcDir);
		}
		if((this.getX()+this.imageWidth>this.width) || this.getX()<0)
			this.xDir *= -1;
		if((this.getY()+this.imageHeight>this.height) || this.getY()<0)
			this.yDir *= -1;
		this.x+=xIncr*this.xDir;
		this.y+=yIncr*this.yDir;


		if(this.xDir>0 && this.yDir>0) //x+,y+: d+r
			this.orcDir=Direction.SOUTHEAST;
		else if(this.xDir>0 && this.yDir<0)//x+,y-: u+r
			this.orcDir=Direction.NORTHEAST;
		else if(this.xDir<0 && this.yDir>0)//x-,y+: d+l
			this.orcDir=Direction.SOUTHWEST;
		else if(this.xDir<0 && this.yDir<0)//x-,y-: u+l
			this.orcDir=Direction.NORTHWEST;
		
		if(isJumping) {
			this.action = OrcImage.jump(this.orcDir);
			if(jumpStart<0) //start the animation timer
				jumpStart=tick_counter;
			if(tick_counter >= jumpStart+this.action.frameCount()) { //if enough time has passed for a jump
				this.toggleJumping(); //toggle the animation flag
				jumpStart=-1; // reset the animation timer
			}
		}
		
	}
}