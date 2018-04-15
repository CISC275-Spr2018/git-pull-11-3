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
		ModelUpdateLogic mul; // Arvin: needed to give the Controller a ModelUpdateLogic 
		
		//literally just a clock to count the game ticks
		//increments every time the model and view are updated
		private int tick_counter = 0;
		
		
		public Controller(){
			button.setSize(20,20);
			//button.addActionListener(new ButtonClickHandler(model));
			
			view = new View(button);
			model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
			view.button.addActionListener(new ButtonClickHandler(model));
			mul = new ModelUpdateLogic(model); // Arvin: create a new ModelUpdateLogic and give it the Model
			
			
			Timer t = new Timer(DRAWDELAY, this);
			t.start();
		}
		
		
		//the timer calls this method after each DRAWDELAY
		public void actionPerformed(ActionEvent e) {
			//model.updateLocationAndDirection(tick_counter);
			mul.updateLocationAndDirection(tick_counter); // Arvin: updates called by the ModelUpdateLogic class instead of the Model itself
			view.update(model);
			tick_counter+=1;
		}
		 
		public static void main(String[] args){
			EventQueue.invokeLater(new Runnable(){
				public void run(){
					
					new Controller();
					view.addKeyListener(new KeyListener(model));
					view.setVisible(true);
				}
			});
		}
	}
