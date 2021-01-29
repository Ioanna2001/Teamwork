package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlert6 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		if (Option2Alert.frame != null) {
			Option2Alert.frame.setVisible(false);
			if (Option2Alert.c1.isSelected()) {
				Corona.user.getSymptoms()[0] = 1;
			}
			if (Option2Alert.c2.isSelected()) {
				Corona.user.getSymptoms()[1] = 1;
			}
			if (Option2Alert.c3.isSelected()) {
				Corona.user.getSymptoms()[2] = 1;
			}
			if (Option2Alert.c4.isSelected()) {
				Corona.user.getSymptoms()[3] = 1;
			}
			if (Option2Alert.c5.isSelected()) {
				Corona.user.getSymptoms()[4] = 1;
			}
			if (Option2Alert.c6.isSelected()) {
				Corona.user.getSymptoms()[5] = 1;
			}
			if (Option2Alert.c7.isSelected()) {
				Corona.user.getSymptoms()[6] = 1;
			}
			if (Option2Alert.c8.isSelected()) {
				Corona.user.getSymptoms()[7] = 1;
			}
			if (Option2Alert.c9.isSelected()) {
				Corona.user.getSymptoms()[8] = 1;
			}
			if (Option2Alert.c10.isSelected()) {
				Corona.user.getSymptoms()[9] = 1;
			}
			if (Option2Alert.c11.isSelected()) {
				Corona.user.getSymptoms()[10] = 1;
			}
			if (Option2Alert.c12.isSelected()) {
				Corona.user.getSymptoms()[11] = 1;
			}
			if (Option2Alert.c13.isSelected()) {
				Corona.user.getSymptoms()[12] = 1;
			}
		} else {
			GUI.frame7.setVisible(false);
			if (GUI.c1.isSelected()) {
				Corona.user.getSymptoms()[0] = 1;
			}
			if (GUI.c2.isSelected()) {
				Corona.user.getSymptoms()[1] = 1;
			}
			if (GUI.c3.isSelected()) {
				Corona.user.getSymptoms()[2] = 1;
			}
			if (GUI.c4.isSelected()) {
				Corona.user.getSymptoms()[3] = 1;
			}
			if (GUI.c5.isSelected()) {
				Corona.user.getSymptoms()[4] = 1;
			}
			if (GUI.c6.isSelected()) {
				Corona.user.getSymptoms()[5] = 1;
			}
			if (GUI.c7.isSelected()) {
				Corona.user.getSymptoms()[6] = 1;
			}
			if (GUI.c8.isSelected()) {
				Corona.user.getSymptoms()[7] = 1;
			}
			if (GUI.c9.isSelected()) {
				Corona.user.getSymptoms()[8] = 1;
			}
			if (GUI.c10.isSelected()) {
				Corona.user.getSymptoms()[9] = 1;
			}
			if (GUI.c11.isSelected()) {
				Corona.user.getSymptoms()[10] = 1;
			}
			if (GUI.c12.isSelected()) {
				Corona.user.getSymptoms()[11] = 1;
			}
			if (GUI.c13.isSelected()) {
				Corona.user.getSymptoms()[12] = 1;
			}
		}
		if (Corona.getStatus().equals("C")) {
			CovidCases.addSymptoms_Counter(Corona.user.getSymptoms());
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
