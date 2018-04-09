import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * Do not modify this file without permission from your TA.
 **/
public class Controller implements ActionListener{

	private static Model model;
	private static View view;
	private final static int DRAWDELAY = 30;
	private static boolean updateFlag= true;
	JButton button = new JButton("Toggle");
	
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		
		button.setSize(20,20);
		button.setVisible(true);	
		button.addActionListener(new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				updateFlag = !updateFlag;
			}
		});
		view.add(button);
		
		Timer t = new Timer(DRAWDELAY, this);
		t.start();
	}
	
	
	//the timer calls this method after each DRAWDELAY
	public void actionPerformed(ActionEvent e) {
		if(updateFlag){
			model.updateLocationAndDirection();
			view.update(model);  
		}
	}
	 
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				new Controller();
				view.addKeyListener(new KeyAdapter(){ //this must be added for key inputs to work
					@Override
			        public void keyPressed(KeyEvent e) {
			            model.keyPressed(e);
			        }
			        @Override
			        public void keyReleased(KeyEvent e) {
			            model.keyReleased(e);
			        } 
				});
				view.setVisible(true);
			}
		});
	}
}
