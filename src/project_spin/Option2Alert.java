package project_spin;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class Option2Alert implements ActionListener {
	static JButton finish;
	static JFrame frame;
	static JRadioButton c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13;

	@Override
	public void actionPerformed(ActionEvent e) {
		GUI.frameM.setVisible(false);
		frame = new JFrame("Symptoms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		frame.setResizable(true);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		int[] symptoms = Corona.user.symptoms;
		JLabel l=new JLabel("Pick your sympotoms:");  
		l.setBounds(20, 30, 150, 50);
		c1 = new JRadioButton("Fever");
		c1.setBounds(150, 30, 500, 50);
		c2 = new JRadioButton("Dry cough");
		c2.setBounds(150, 70, 500, 50);
		c3 = new JRadioButton("Tiredness");
		c3.setBounds(150, 110, 500, 50);
		c4 = new JRadioButton("Aches and pains");
		c4.setBounds(150, 150, 500, 50);
		c5 = new JRadioButton("Sore throat");
		c5.setBounds(150, 190, 500, 50);
		c6 = new JRadioButton("Diarrhoea");
		c6.setBounds(150, 230, 500, 50);
		c7 = new JRadioButton("Conjuctivitis");
		c7.setBounds(150, 270, 500, 50);
		c8 = new JRadioButton("Headache");
		c8.setBounds(150, 310, 500, 50);
		c9 = new JRadioButton("Loss of taste or smell");
		c9.setBounds(150, 350, 500, 50);
		c10 = new JRadioButton("A rash on skin, or discolouration of fingers or toes");
		c10.setBounds(150, 390, 500, 50);
		c11 = new JRadioButton("Difficulty breathing or shortness of breath");
		c11.setBounds(150, 430, 500, 50);
		c12 = new JRadioButton("Cheast pain or pressure");
		c12.setBounds(150, 470, 500, 50);
		c13 = new JRadioButton("Loss of speech or movement");
		c13.setBounds(150, 510, 500, 50);
		if (symptoms[0] == 1) {
			c1.setSelected(true);
		}
		if (symptoms[1] == 1) {
			c2.setSelected(true);
		}
		if (symptoms[2] == 1) {
			c3.setSelected(true);
		}
		if (symptoms[3] == 1) {
			c4.setSelected(true);
		}
		if (symptoms[4] == 1) {
			c5.setSelected(true);
		}
		if (symptoms[5] == 1) {
			c6.setSelected(true);
		}
		if (symptoms[6] == 1) {
			c7.setSelected(true);
		}
		if (symptoms[7] == 1) {
			c8.setSelected(true);
		}
		if (symptoms[8] == 1) {
			c9.setSelected(true);
		}
		if (symptoms[9] == 1) {
			c10.setSelected(true);
		}
		if (symptoms[10] == 1) {
			c11.setSelected(true);
		}
		if (symptoms[11] == 1) {
			c12.setSelected(true);
		}
		if (symptoms[12] == 1) {
			c13.setSelected(true);
		}
		panel.add(l);
		panel.add(c1);
		panel.add(c2);
		panel.add(c3);
		panel.add(c4);
		panel.add(c5);
		panel.add(c6);
		panel.add(c7);
		panel.add(c8);
		panel.add(c9);
		panel.add(c10);
		panel.add(c11);
		panel.add(c12);
		panel.add(c13);
		finish = new JButton("Finish");
		finish.setBounds(10, 80, 125, 25);
		panel.add(finish);
		finish.addActionListener(new NextActionAlert6());
		frame.setVisible(true);
	}

}
