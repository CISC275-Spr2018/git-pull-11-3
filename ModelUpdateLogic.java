/*
 * Arvin:
 * ModelUpdateLogic class holds all methods pertaining to updating
 * the model. Controller should now call this class's updateLocationAndDirection()
 * to update values in Model
 */

public class ModelUpdateLogic {
	private Model model;
	
	public ModelUpdateLogic(Model m) {
		this.model = m;
	}
	
	private int jumpStart=-1;
	public void updateLocationAndDirection(int tick_counter){ // move logic out of model into controller
		//if(!isMoving) return;
		//jump action needs to pre-empt like everything else...
		
		if(!model.getIsMoving()) {
			model.setAction(OrcImage.idle(model.getOrcDir()));
			return;
		} else {
			model.setAction(OrcImage.forward(model.getOrcDir()));
		}
		if((model.getX()+model.getImageWidth()>model.getImageWidth()) || model.getX()<0)
			model.setXDir(-1);
		if((model.getY()+model.getImageHeight()>model.getImageHeight()) || model.getY()<0)
			model.setYDir(-1);
		model.setX(model.getXIncr()*model.getXDir());
		model.setY(model.getYIncr()*model.getYDir());


		if(model.getXDir()>0 && model.getYDir()>0) //x+,y+: d+r
			model.setOrcDir(Direction.SOUTHEAST);
		else if(model.getXDir()>0 && model.getYDir()<0)//x+,y-: u+r
			model.setOrcDir(Direction.NORTHEAST);
		else if(model.getXDir()<0 && model.getYDir()>0)//x-,y+: d+l
			model.setOrcDir(Direction.SOUTHWEST);
		else if(model.getXDir()<0 && model.getYDir()<0)//x-,y-: u+l
			model.setOrcDir(Direction.NORTHWEST);
		
		if(model.getIsJumping()) {
			model.setAction(OrcImage.jump(model.getOrcDir()));
			if(jumpStart<0) //start the animation timer
				jumpStart=tick_counter;
			if(tick_counter >= jumpStart+model.getAction().frameCount()) { //if enough time has passed for a jump
				model.toggleJumping(); //toggle the animation flag
				jumpStart=-1; // reset the animation timer
			}
		}
		
	}

}
