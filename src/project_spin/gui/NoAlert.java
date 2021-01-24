package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.*;
import java.awt.event.ActionListener;

class NoAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Option3Alert.frame.setVisible(false);
		GUI.guiMenu();
	}

}
