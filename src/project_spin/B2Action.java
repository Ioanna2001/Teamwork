package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class B2Action implements ActionListener {
	private JFrame parent;

	B2Action(JFrame parent) {
		this.parent = parent;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setStatus("F");
		GUI.gui2();
	}
}
