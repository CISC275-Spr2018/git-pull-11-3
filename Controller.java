import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * Do not modify this file without permission from your TA.
 **/
public class Controller implements ActionListener{

	private static Model model;
	private static View view;
	private final static int DRAWDELAY = 30;
	
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		
		Timer t = new Timer(DRAWDELAY, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.updateLocationAndDirection();
		view.update(model);  
	}
	 
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame j1 = new JFrame();
				new Controller();
				view.addKeyListener(new KeyAdapter(){
					@Override
			        public void keyPressed(KeyEvent e) {
			            model.keyPressed(e);
			        }
			        @Override
			        public void keyReleased(KeyEvent e) {
			            model.keyReleased(e);
			        } 
				});
				j1.add(view);
				j1.setVisible(true);
			}
		});
	}
}
