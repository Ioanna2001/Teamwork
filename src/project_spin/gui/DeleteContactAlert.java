package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteContactAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameE.setVisible(false);
		List<String> contactName = GUI.contacts.getSelectedValuesList();
		for (String i:contactName) {
			if (Corona.user.getContactName().contains(i)) {
				Corona.user.deleteContact(Corona.user.getContactName().indexOf(i));
			}
		}
		GUI.guiEditContacts();
	}

}
