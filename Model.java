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

class Model {
  private int width, height, imageWidth, imageHeight;
  private int x=0;
  private int y=0;
  private int xDir = 1;
  private int yDir = 0;
  private final int xIncr = 8;
  private final int yIncr = 2;

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
  public int[] getDirect(){
    int[] dir = {this.xDir, this.yDir};
    return dir;
  }
  public int getxIncr() {
	  return xIncr;
  }
  public int getyIncr() {
	  return yIncr;
  }


  public void updateLocationAndDirection(){
    if((this.getX()+this.imageWidth>this.width) || this.getX()<0)
      this.xDir *= -1;
    if((this.getY()+this.imageHeight>this.height) || this.getY()<0)
      this.yDir *= -1;
    this.x+=xIncr*this.xDir;
    this.y+=yIncr*this.yDir;
  }
}