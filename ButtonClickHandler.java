import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickHandler implements ActionListener {
	
	private Model model;
	
	ButtonClickHandler(Model m){
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.toggleMoving();
	}

}
