package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlertLogIn implements ActionListener {
	static int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameL.setVisible(false);
		String password = GUI.passwordText.getText();
		String email = GUI.emailText2.getText();
		if (Passwords.emailMatchesPassword(password, email) && i < 5) {
			for (User u:User.users) {
				if (u.password.equals(password)) {
					Corona.user = u;
					if (u instanceof CovidCases) {
						Corona.setStatus("C");
					} else {
						Corona.setStatus("F");
					}
				}
			}
			GUI.guiMenu();
		} else if (Passwords.emailMatchesPassword(password, email) == false && i < 5) {
			i ++;
			GUI.frameL.setVisible(false);
			GUI.guiLogIn();
		} else if (i >= 5) {
			System.exit(0);
		}
	}

}
