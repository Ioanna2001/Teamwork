package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddContactAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Option1Alert.frame.setVisible(false);
		GUI.guiAddContacts();
	}

}
