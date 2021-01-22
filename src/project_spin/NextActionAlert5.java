package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextActionAlert5 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.age = (Integer) GUI.spinner.getValue();
		if (Corona.location == null) {
			Corona.user = new CovidCases(Corona.ssn, Corona.password, Corona.name,
					Corona.email, Corona.age);
		} else {
			Corona.user = new CovidCases(Corona.location, Corona.ssn, Corona.password,
					Corona.name, Corona.email, Corona.age);
		}
		GUI.frame6.setVisible(false);
		Corona.user.addSymptoms();
	}
}
