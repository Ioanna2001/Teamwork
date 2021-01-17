package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class B1Action implements ActionListener{
	private JFrame parent;

	B1Action(JFrame parent) {
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.status = "C";
		GUI.gui2();
	}
}
