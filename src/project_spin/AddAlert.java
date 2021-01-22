package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AddAlert implements ActionListener {
	String email;
	static JFrame frame = null;
	@Override
	public void actionPerformed(ActionEvent e) {
		email = GUI.contactName.getText();
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
		if (GUI.add.isSelected()) {
			GUI.frameC.setVisible(false);
			GUI.guiAddContacts();
		}else {
			GUI.guiMenu();
		}
	}
}
