package project_spin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

class Option1Alert implements ActionListener {
	static JList contacts;
	static JFrame frame;

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] array = new String[Corona.user.contactName.size()];
		for (int i = 0; i < Corona.user.contactName.size(); i++) {
			array[i] = Corona.user.contactName.get(i);
		}
		GUI.frameM.setVisible(false);
		contacts = new JList(array);
		frame = new JFrame("Edit Contacts");
		frame.setSize(600, 200);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.add(contacts);
		JButton add = new JButton("Add Contact");
		add.setBounds(10,150, 150,25);
		JButton delete = new JButton("Delete Contact");
		delete.setBounds(200, 150, 150, 25);
		JButton finish = new JButton("Finish");
		finish.setBounds(400, 150, 150, 25);
		panel.add(delete);
		panel.add(add);
		delete.addActionListener(new DeleteContactAlert());
		add.addActionListener(new AddContactAlert());
		finish.addActionListener(new FinishAlert());
		frame.setVisible(true);
		}
	}
