package project_spin.gui;

import java.awt.event.ActionEvent;
import project_spin.exe.Corona;
import project_spin.*;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class YesAlert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CovidCases.setStatus((CovidCases) Corona.user, 0);
		Option3Alert.frame.setVisible(false);
		JFrame frame2 = new JFrame("Succes");
		JOptionPane.showMessageDialog(frame2 , "Your status has been succesfully changed");
		GUI.guiMenu();
	}

}
