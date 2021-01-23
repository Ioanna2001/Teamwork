package project_spin;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class Option3Alert implements ActionListener {
	static JFrame frame;
	@Override
	public void actionPerformed(ActionEvent e) {
		frame = new JFrame("Edit status");
		frame.setSize(300, 200);
		frame.setResizable(true);
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(layout);
		JLabel label = new JLabel("Have your symptoms stopped for more than fifteen days?");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		frame.add(label);
		JButton yes = new JButton("Yes");
		JButton no = new JButton("No");
		frame.add(no);
		frame.add(yes);
		yes.addActionListener(new YesAlert());
		no.addActionListener(new NoAlert());
		frame.setVisible(true);
	}

}
