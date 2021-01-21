package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert6 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		if (Corona.status.equals("C")) {
			if (GUI.c1.isSelected()) {
				Corona.cc.symptoms[0] = 1;
			}
			if (GUI.c2.isSelected()) {
				Corona.cc.symptoms[1] = 1;
			}
			if (GUI.c3.isSelected()) {
				Corona.cc.symptoms[2] = 1;
			}
			if (GUI.c4.isSelected()) {
				Corona.cc.symptoms[3] = 1;
			}
			if (GUI.c5.isSelected()) {
				Corona.cc.symptoms[4] = 1;
			}
			if (GUI.c6.isSelected()) {
				Corona.cc.symptoms[5] = 1;
			}
			if (GUI.c7.isSelected()) {
				Corona.cc.symptoms[6] = 1;
			}
			if (GUI.c8.isSelected()) {
				Corona.cc.symptoms[7] = 1;
			}
			if (GUI.c9.isSelected()) {
				Corona.cc.symptoms[8] = 1;
			}
			if (GUI.c10.isSelected()) {
				Corona.cc.symptoms[9] = 1;
			}
			if (GUI.c11.isSelected()) {
				Corona.cc.symptoms[10] = 1;
			}
			if (GUI.c12.isSelected()) {
				Corona.cc.symptoms[11] = 1;
			}
			if (GUI.c13.isSelected()) {
				Corona.cc.symptoms[12] = 1;
			}
			CovidCases.addSymptoms_Counter(Corona.cc.symptoms);
		} else {
			if (GUI.c1.isSelected()) {
				Corona.fc.symptoms[0] = 1;
				i ++;
			}
			if (GUI.c2.isSelected()) {
				Corona.fc.symptoms[1] = 1;
				i ++;
			}
			if (GUI.c3.isSelected()) {
				Corona.fc.symptoms[2] = 1;
				i ++;
			}
			if (GUI.c4.isSelected()) {
				Corona.fc.symptoms[3] = 1;
				i ++;
			}
			if (GUI.c5.isSelected()) {
				Corona.fc.symptoms[4] = 1;
				i ++;
			}
			if (GUI.c6.isSelected()) {
				Corona.fc.symptoms[5] = 1;
				i ++;
			}
			if (GUI.c7.isSelected()) {
				Corona.fc.symptoms[6] = 1;
				i ++;
			}
			if (GUI.c8.isSelected()) {
				Corona.fc.symptoms[7] = 1;
				i ++;
			}
			if (GUI.c9.isSelected()) {
				Corona.fc.symptoms[8] = 1;
				i ++;
			}
			if (GUI.c10.isSelected()) {
				Corona.fc.symptoms[9] = 1;
				i ++;
			}
			if (GUI.c11.isSelected()) {
				Corona.fc.symptoms[10] = 1;
				i ++;
			}
			if (GUI.c12.isSelected()) {
				Corona.fc.symptoms[11] = 1;
				i ++;
			}
			if (GUI.c13.isSelected()) {
				Corona.fc.symptoms[12] = 1;
				i ++;
			}
			if (i > 2) {
				GUI.warning();
			}
		}
	}

}
