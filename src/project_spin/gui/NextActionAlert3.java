package project_spin.gui;

import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextActionAlert3 implements ActionListener {
	static int i = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setPassword(GUI.codeText.getText());
		if (Passwords.checkPasswordVerification(Corona.getPassword(), Corona.getEmail()) && i < 5) {
			GUI.gui6();
		} else if (Passwords.checkPasswordVerification(Corona.getPassword(), Corona.getEmail()) == false && i < 5) {
			i ++;
			GUI.frame4.setVisible(false);
			GUI.gui5();
		} else if (i >= 5){
			System.exit(0);
		}
	}

}
