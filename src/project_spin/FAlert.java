package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class FAlert implements ActionListener {
	String email;
	static JFrame frame = null;

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameC.setVisible(false);
		email = GUI.contactEmail.getText();
		if (SendEmail.isValid(email)) {
			Corona.user.contactName.add(email);
			Corona.user.contactEmail.add(GUI.contactEmail.getText());
			SendEmail fc = new SendEmail(GUI.contactEmail.getText());
			if (Corona.status.equals("C")) {
				try {
					fc.firstContactMail();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					fc.secondContactEmail();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else {
			GUI.frameC.setVisible(false);
			frame = new JFrame("Warning");
			JOptionPane.showMessageDialog(frame , "Please enter a valid email. "
					+ "Your contact has not been added");
			GUI.guiAddContacts();
		}
		GUI.frameC.setVisible(false);
		if (GUI.frameM != null) {
			GUI.guiEditContacts();
		} else {
			GUI.guiMenu();
		}
	}
}

