package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class NextActionAlert5 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setAge((Integer) GUI.spinner.getValue());
		if (Corona.getLocation() == null) {
			Corona.user = new CovidCases(Corona.getSsn(), Corona.getPassword(), Corona.getName(),
					Corona.getEmail(), Corona.getAge());
		} else {
			Corona.user = new CovidCases(Corona.getLocation(), Corona.getSsn(), Corona.getPassword(),
					Corona.getName(), Corona.getEmail(), Corona.getAge());
		}
		GUI.frame6.setVisible(false);
		Corona.user.addSymptoms();
	}
}
