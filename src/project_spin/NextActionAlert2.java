package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert2 implements ActionListener {
	static int i = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		int ssn = 0;
		try {
			ssn = Integer.parseInt(GUI.ssnText.getText());
		} catch (Exception ex) {
			if (i < 5) {//the user has 5 tries
				GUI.frame3.setVisible(false);
				i ++;
				GUI.gui4();
			} else {
				System.exit(0);
			}
			
		}
		Corona.setSsn(ssn);
	}

}
