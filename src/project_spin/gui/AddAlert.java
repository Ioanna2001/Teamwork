package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddAlert implements ActionListener {
	String email;
	public static JFrame frame = null;
	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameC.setVisible(false);
		email = GUI.contactEmail.getText();
		if (SendEmail.isValid(email)) {
			Corona.user.getContactName().add(email);
			Corona.user.getContactEmail().add(GUI.contactEmail.getText());
			SendEmail fc = new SendEmail(GUI.contactEmail.getText());
			if (Corona.getStatus().equals("C")) {
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
		}
		GUI.guiAddContacts();
	}
}
