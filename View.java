import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;


/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
class View extends JPanel {

	final private int width, height, imageWidth, imageHeight;
	public JButton button;
	private JFrame frame;


	private OrcImage action;
	private OrcImage prevAction;
	private static HashMap<OrcImage, BufferedImage[]> images;

	private int x, y, xDir, yDir; //need global state attribute information for the repaint method

	private int picNum = 0;
	BufferedImage[] pics;

	//Read image from file and return
	private BufferedImage createImage(OrcImage image) {//String path){
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(new File(image.path()));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// TODO: Change this method so you can load other orc animation bitmaps
	}
	View(JButton button){
		setFocusable(true); // necessary to take key inputs
		
		this.width=500;
		this.height=300;
		this.imageWidth=165;
		this.imageHeight=165;
		this.frame = new JFrame();
		this.frame.add(this);
		this.button = button;
		this.add(this.button);
		
		
		
		images = new HashMap<OrcImage,BufferedImage[]>();
		for(OrcImage orcImage : OrcImage.values()) { //use an enum to map directions to images
			BufferedImage img = createImage(orcImage);
			pics = new BufferedImage[orcImage.frameCount()];
			for(int i = 0; i < orcImage.frameCount(); i++)
				pics[i] = img.getSubimage(this.imageWidth*i, 0, this.imageWidth, this.imageHeight);
			//System.out.println(images+","+orcImage+","+pics);
			images.put(orcImage,pics);
		}
		//this.frame.setSize(100,100);
		this.action = OrcImage.FORWARD_S;
		this.frame.setBackground(Color.gray);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(this.width, this.height);
		this.frame.setVisible(true);
	}
	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}
	public int getImageWidth(){
		return this.imageWidth;
	}
	public int getImageHeight(){
		return this.imageHeight;
	}

	public void update(Model model){
		this.removeAll();
		this.action = model.getAction();
		this.x = model.getX();
		this.y = model.getY();

		if(this.action!=this.prevAction && this.picNum!=0) { //if there is a new action to perform
			picNum=0;//reset the animation
		}

		setBackground(Color.gray);
		this.picNum = (this.picNum + 1) % this.action.frameCount();
		this.frame.getGraphics().drawImage(this.images.get(this.action)[this.picNum],this.x,this.y,Color.gray, this);
		this.add(this.button);
		this.button.setVisible(true);
		this.button.repaint();
		this.prevAction = this.action;
	}
}