package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import java.awt.event.ActionListener;

public class AlertLogIn implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Corona.login();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
