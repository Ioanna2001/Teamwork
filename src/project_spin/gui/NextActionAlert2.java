package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlert2 implements ActionListener {
	static int i = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = GUI.ssnText.getText();
		int ssn = 0;
		if (temp.matches("\\d+") && i < 5) {
			ssn = Integer.parseInt(temp);
			if (Ssn.checkSsn(ssn) == true) {
				Corona.setSsn(ssn);
				SendEmail sendEmail = new SendEmail(Corona.getEmail());
				GUI.gui5();
				try {
					sendEmail.covidCaseMail();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				i ++;
				GUI.frame3.setVisible(false);
				GUI.gui4();
			}
		} else {
			i ++;
			GUI.frame3.setVisible(false);
			GUI.gui4();
		}
		if (i == 4) {
			if (Ssn.checkSsn(ssn) == false) {
				System.exit(0);
			}
		} else if (i > 4) {
			System.exit(0);
		}
	}

}
