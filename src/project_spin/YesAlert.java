package project_spin;

import java.awt.event.ActionEvent;
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
