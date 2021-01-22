package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Option3Alert implements ActionListener {
	static JFrame frame;
	@Override
	public void actionPerformed(ActionEvent e) {
		frame = new JFrame("Edit status");
		frame.setSize(450, 200);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		JLabel label = new JLabel("Have your symptoms stopped for more than fifteen days?");
		label.setBounds(10, 10, 300, 25);
		panel.add(label);
		JButton yes = new JButton("Yes");
		yes.setBounds(10, 50, 80, 25);
		JButton no = new JButton("No");
		no.setBounds(150, 50, 80, 25);
		panel.add(no);
		panel.add(yes);
		yes.addActionListener(new YesAlert());
		no.addActionListener(new NoAlert());
		frame.setVisible(true);
	}

}
