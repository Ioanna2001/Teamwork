package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class DeleteContactAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameE.setVisible(false);
		List<String> contactName = GUI.contacts.getSelectedValuesList();
		for (String i:contactName) {
			if (Corona.user.contactName.contains(i)) {
				Corona.user.deleteContact(Corona.user.contactName.indexOf(i));
			}
		}
		GUI.guiEditContacts();
	}

}
