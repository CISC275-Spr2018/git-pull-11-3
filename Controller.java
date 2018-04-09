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
	private final static int DRAWDELAY = 50;
	private static boolean updateFlag= true;
	JButton button = new JButton("Toggle");
	
	//literally just a clock to count the game ticks
	//increments every time the model and view are updated
	private int tick_counter = 0;
	
	
	public Controller(){
		button.setSize(20,20);
		//button.addActionListener(new ButtonClickHandler(model));
		
		view = new View(button);
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
		view.button.addActionListener(new ButtonClickHandler(model));
		
		
		Timer t = new Timer(DRAWDELAY, this);
		t.start();
	}
	
	
	//the timer calls this method after each DRAWDELAY
	public void actionPerformed(ActionEvent e) {
		model.updateLocationAndDirection(tick_counter);
		view.update(model);
		tick_counter+=1;
	}
	 
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				new Controller();
				view.addKeyListener(model);
				view.setVisible(true);
			}
		});
	}
}
