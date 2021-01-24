package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlertFc implements ActionListener {
	static int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setPassword(GUI.fcText.getText());
		if (Passwords.checkPasswordVerification(Corona.getPassword(), Corona.getEmail()) && i < 5) {
			Corona.user = new User(Corona.getPassword(), Corona.getName(), Corona.getEmail());
			GUI.gui8();
		} else if (Passwords.checkPasswordVerification(Corona.getPassword(), Corona.getEmail()) == false && i < 5) {
			//TODO warning
			i ++;
			GUI.frameFc.setVisible(false);
			GUI.guiFc();
		} else if (i >= 5){
			System.exit(0);
		}

	}

}
