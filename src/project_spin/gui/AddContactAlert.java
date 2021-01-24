package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.*;
import java.awt.event.ActionListener;

public class AddContactAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameE.setVisible(false);
		GUI.guiAddContacts();
	}

}
