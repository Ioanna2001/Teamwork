package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.*;
import java.awt.event.ActionListener;

public class Option1Alert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameM.setVisible(false);
		GUI.guiEditContacts();
		}
	}
