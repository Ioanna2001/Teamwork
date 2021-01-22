package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert6 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
			if (GUI.c1.isSelected()) {
				Corona.user.symptoms[0] = 1;
			}
			if (GUI.c2.isSelected()) {
				Corona.user.symptoms[1] = 1;
			}
			if (GUI.c3.isSelected()) {
				Corona.user.symptoms[2] = 1;
			}
			if (GUI.c4.isSelected()) {
				Corona.user.symptoms[3] = 1;
			}
			if (GUI.c5.isSelected()) {
				Corona.user.symptoms[4] = 1;
			}
			if (GUI.c6.isSelected()) {
				Corona.user.symptoms[5] = 1;
			}
			if (GUI.c7.isSelected()) {
				Corona.user.symptoms[6] = 1;
			}
			if (GUI.c8.isSelected()) {
				Corona.user.symptoms[7] = 1;
			}
			if (GUI.c9.isSelected()) {
				Corona.user.symptoms[8] = 1;
			}
			if (GUI.c10.isSelected()) {
				Corona.user.symptoms[9] = 1;
			}
			if (GUI.c11.isSelected()) {
				Corona.user.symptoms[10] = 1;
			}
			if (GUI.c12.isSelected()) {
				Corona.user.symptoms[11] = 1;
			}
			if (GUI.c13.isSelected()) {
				Corona.user.symptoms[12] = 1;
			}
			if (Corona.status.equals("C")) {
			CovidCases.addSymptoms_Counter(Corona.user.symptoms);
			} else {
				if (i > 2) {
					GUI.warning();
				}
			}
			if (Option2Alert.finish.isSelected() == false) {
				GUI.guiAddContacts();
			} else {
				Option2Alert.frame.setVisible(false);
				GUI.guiMenu();
			}
	}

}
