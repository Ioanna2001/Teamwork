package project_spin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class NextActionAlert3 implements ActionListener {
	static int i = 0;
	JTextField text;

	NextActionAlert3(JTextField text) {
		text = this.text;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Corona.setPassword(text.getText());
		if (Passwords.checkPasswordVerification(Corona.getPassword()) == false && i < 5) {
			i ++;
			GUI.frame4.setVisible(false);
			GUI.gui5();
		} else if (Passwords.checkPasswordVerification(Corona.getPassword()) == true && i < 5) {
			GUI.frame4.setVisible(false);
			JFrame frame = new JFrame("Covid Tracker");
			FlowLayout layout = new FlowLayout();
			layout.setAlignment(FlowLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(layout);
			JLabel label = new JLabel("Succesful Sign Up!");
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			frame.setVisible(true);
		} else {
			System.exit(0);
		}
	}

}
