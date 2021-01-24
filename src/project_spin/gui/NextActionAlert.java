package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setName(GUI.nameText.getText());
		Corona.setEmail(GUI.emailText.getText());
		if (Corona.getEmail().equals("") || Corona.getName().equals("") || SendEmail.isValid(Corona.getEmail()) == false) {
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
