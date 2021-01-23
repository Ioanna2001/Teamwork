package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert6 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Option2Alert.frame.setVisible(false);
		int i = 0;
		if (Option2Alert.c1.isSelected()) {
			Corona.user.symptoms[0] = 1;
		}
		if (Option2Alert.c2.isSelected()) {
			Corona.user.symptoms[1] = 1;
		}
		if (Option2Alert.c3.isSelected()) {
			Corona.user.symptoms[2] = 1;
		}
		if (Option2Alert.c4.isSelected()) {
			Corona.user.symptoms[3] = 1;
		}
		if (Option2Alert.c5.isSelected()) {
			Corona.user.symptoms[4] = 1;
		}
		if (Option2Alert.c6.isSelected()) {
			Corona.user.symptoms[5] = 1;
		}
		if (Option2Alert.c7.isSelected()) {
			Corona.user.symptoms[6] = 1;
		}
		if (Option2Alert.c8.isSelected()) {
			Corona.user.symptoms[7] = 1;
		}
		if (Option2Alert.c9.isSelected()) {
			Corona.user.symptoms[8] = 1;
		}
		if (Option2Alert.c10.isSelected()) {
			Corona.user.symptoms[9] = 1;
		}
		if (Option2Alert.c11.isSelected()) {
			Corona.user.symptoms[10] = 1;
		}
		if (Option2Alert.c12.isSelected()) {
			Corona.user.symptoms[11] = 1;
		}
		if (Option2Alert.c13.isSelected()) {
			Corona.user.symptoms[12] = 1;
		}
		if (Corona.status.equals("C")) {
			CovidCases.addSymptoms_Counter(Corona.user.symptoms);
		} else {
			if (i > 2) {
				GUI.warning();
			}
		}
		if (Option2Alert.finish == null) {
			GUI.guiAddContacts();
		} else {
			Option2Alert.frame.setVisible(false);
			GUI.guiMenu();
		}
	}
}
