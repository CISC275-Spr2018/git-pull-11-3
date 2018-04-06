import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonActionListener implements ActionListener {
	Controller controller;
	
	@Override
	public void actionPerformed(ActionEvent e) {
			Controller.setUpdateFlag(!Controller.getupdateFlag());
		}
	
	}
