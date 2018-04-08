import javax.swing.AbstractAction;
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

/**
 * Do not modify this file without permission from your TA.
 **/

	public class Controller  {

	public static Model model;
	public static View view;
	
	private final static int DRAWDELAY = 30;
	private static boolean updateFlag= true;
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
	}
	
  //run the simulation
	public void start(){
		for(int i = 0; i < 5000; i++)
		{
			//increment the x and y coordinates, alter direction if necessary
			model.updateLocationAndDirection();
			//update the view
			view.update(model);
		}
	}
	public static boolean getupdateFlag(){
		return updateFlag;
	}
	public static void setUpdateFlag(boolean flag){
		updateFlag=flag;
	}
	
	public static void main(String[] args){
		
		Controller.view = new View();
		Controller.model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Timer t = new Timer(DRAWDELAY, new AbstractAction() {
					public void actionPerformed(ActionEvent e) {
						if (updateFlag){
						model.updateLocationAndDirection();
						view.update(model);
						}
						
						
					}
				});
				t.start();
			}
		});
	}

	
}
