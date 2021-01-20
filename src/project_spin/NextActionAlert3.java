package project_spin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class NextActionAlert3 implements ActionListener {
	static int i = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setPassword(GUI.codeText.getText());
		if (Passwords.checkPasswordVerification(Corona.getPassword()) == false && i < 5) {
			i ++;
			GUI.frame4.setVisible(false);
			GUI.gui5();
		} else if (Passwords.checkPasswordVerification(Corona.getPassword()) == true && i < 5) {
			GUI.gui6();
		} else {
			System.exit(0);
		}
	}

}
