package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

public class B2Action implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setStatus("F");
		GUI.gui2();
	}
}
