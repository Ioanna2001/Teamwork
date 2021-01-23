package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FinishAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameE.setVisible(false);
		GUI.guiMenu();
	}

}
