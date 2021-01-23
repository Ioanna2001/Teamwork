package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

class Option1Alert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameM.setVisible(false);
		GUI.guiEditContacts();
		}
	}
