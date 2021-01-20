package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setName(GUI.nameText.getText());
		Corona.setEmail(GUI.emailText.getText());
		if (Corona.email.equals("") || Corona.name.equals("") || SendEmail.isValid(Corona.email) == false) {
			GUI.frame1.setVisible(false);
			GUI.gui2();
		} else {
			if (Corona.getStatus().equals("C")) {
				try {
					Corona.covidCase();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					Corona.firstContact();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
