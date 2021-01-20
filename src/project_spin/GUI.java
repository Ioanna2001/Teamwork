package project_spin;

import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class GUI {
	static 		JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,c11, c12, c13;
	static JFrame frame;
	static JFrame frame1;
	static JFrame frame2;
	static JFrame frame3;
	static JTextField nameText;
	static JTextField emailText;
	static JTextField ssnText;
	static JFrame frame4;
	static JTextField codeText;
	static JFrame frame5;
	static JFrame frame6;
	static JSpinner spinner;

	static void gui() {
		frame = new JFrame("Welcome to the WHO Platform Covid Tracker");
		frame.setBounds(0, 0, 300, 200);
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(layout);
		JLabel label = new JLabel();
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		JButton button1 = new JButton("Sign Up");
		JButton button2 = new JButton("Log in");
		frame.add(button1);
		frame.add(button2);
		button1.addActionListener(new AlertSignUp(frame));
		button2.addActionListener(new AlertLogIn(frame));
		frame.setVisible(true);
	}
	static void gui3() {
		frame.setVisible(false);
		frame2 = new JFrame("Set Status");
		frame2.setSize(700, 400);
		frame.setResizable(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame2.add(panel);
		JLabel l = new JLabel("Select Covid Patient if you are a Covid-19 patient "
				+ "or First Contact if you are a patient's first contact");
		panel.add(l);
		JButton b1 = new JButton("Covid Patient");
		JButton b2 = new JButton("First Contact");
		panel.add(b2);
		panel.add(b1);
		b1.addActionListener(new B1Action(frame2));
		b2.addActionListener(new B2Action(frame2));
		frame2.setVisible(true);
		}

	static void gui2() {
		frame2.setVisible(false);
		frame1 = new JFrame("Personal Information");
		frame1.setSize(350, 200);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame1.add(panel);
		panel.setLayout(null);
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 20, 80, 25);
		panel.add(nameLabel);
		nameText = new JTextField(100);
		nameText.setBounds(100, 20, 165, 25);
		panel.add(nameText);
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 50, 80, 25);
		panel.add(emailLabel);
		emailText = new JTextField(100);
		emailText.setBounds(100, 50, 165, 25);
		panel.add(emailText);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panel.add(next);
		next.addActionListener(new NextActionAlert());
		frame1.setVisible(true);
	}
//DEN TELEIWSAN!!!!!!
	static void gui4() {
		frame1.setVisible(false);
		frame3 = new JFrame("SSN");
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame3.add(panel);
		frame3.setSize(350, 200);
		panel.setLayout(null);
		ssnText = new JTextField(6);
		ssnText.setBounds(100, 20, 165, 25);
		panel.add(ssnText);
		JLabel ssnLabel = new JLabel("SSN");
		ssnLabel.setBounds(10, 20, 80, 25);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panel.add(ssnLabel);
		panel.add(next);
		next.addActionListener(new NextActionAlert2());
		frame3.setVisible(true);
	}

	static void gui5() {
		frame3.setVisible(false);
		frame4 = new JFrame("Verify Code");
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setSize(350, 200);
		JPanel panel = new JPanel();
		frame4.add(panel);
		panel.setLayout(null);
		JLabel l = new JLabel("Verification code");
		l.setBounds(20, 20, 150, 20);
		panel.add(l);
		codeText = new JTextField(5);
		codeText.setBounds(100, 20, 165, 25);
		panel.add(codeText);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panel.add(next);
		next.addActionListener(new NextActionAlert3());
		frame4.setVisible(true);
	}

	static void gui6() {
		frame4.setVisible(false);
		frame5 = new JFrame("Location");
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setSize(350, 200);
		frame5.setResizable(true);
		JPanel panel = new JPanel();
		frame5.add(panel);
		panel.setLayout(null);
		JLabel l=new JLabel("Choose location:");  
		l.setBounds(50,50,300,20);  
		c1 = new JCheckBox("Eastern Macedonia and Thrace");
		c1.setBounds(100,100,150,20); 
		c2 = new JCheckBox("Central Macedonia");
		c2.setBounds(100,100,150,20);
		c3 = new JCheckBox("West Macedonia");
		c3.setBounds(100,100,150,20);
		c4 = new JCheckBox("Epirus");
		c4.setBounds(100,100,150,20);
		c5 = new JCheckBox("Thessaly");
		c5.setBounds(100,100,150,20);
		c6 = new JCheckBox("Ionian Islands");
		c6.setBounds(100,100,150,20);
		c7 = new JCheckBox("West Greece");
		c7.setBounds(100,100,150,20);
		c8 = new JCheckBox("Central Greece");
		c8.setBounds(100,100,150,20);
		c9 = new JCheckBox("Attica");
		c9.setBounds(100,100,150,20);
		c10 = new JCheckBox("Peloponnese");
		c10.setBounds(100,100,150,20);
		c11 = new JCheckBox("North Aegean");
		c11.setBounds(100,100,150,20);
		c12 = new JCheckBox("South Aegean");
		c12.setBounds(100,100,150,20);
		c13 = new JCheckBox("Crete");
		c13.setBounds(100,100,150,20);
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
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panel.add(next);
		next.addActionListener(new NextActionAlert4());
		frame5.setVisible(true);
	}

	static void gui7() {
		frame5.setVisible(false);
		frame6 = new JFrame("Age");
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setSize(350, 200);
		JPanel panel = new JPanel();
		frame6.add(panel);
		panel.setLayout(null);
		SpinnerModel value = new SpinnerNumberModel(0, 0, 99, 1);
		spinner = new JSpinner(value);
		spinner.setBounds(100, 100, 50, 30);
		panel.add(spinner);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panel.add(next);
		next.addActionListener(new NextActionAlert5());
		frame6.setVisible(true);
	}
}
