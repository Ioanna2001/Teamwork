package project_spin;

import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {
	static JFrame frame;
	static JFrame frame1;
	static JFrame frame2;
	static JFrame frame3;
	static JTextField nameText;
	static JTextField emailText;
	static JTextField ssnText;
	static JButton next = new JButton("Next");
	static JFrame frame4;

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
		next.setBounds(10, 80, 80, 25);
		panel.add(next);
		next.addActionListener(new NextActionAlert());
		frame1.setVisible(true);
	}

	static void gui3() {
		frame.setVisible(false);
		frame2 = new JFrame("Set Status");
		frame2.setSize(700, 400);
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
//DEN TELEIWSAN!!!!!!
	static void gui4() {
		frame1.setVisible(false);
		frame3 = new JFrame("SSN");
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame3.add(panel);
		frame3.setSize(350, 200);
		panel.setLayout(null);
		JLabel ssnLabel = new JLabel("SSN");
		ssnLabel.setBounds(10, 20, 80, 25);
		panel.add(ssnLabel);
		ssnText = new JTextField(6);
		ssnText.setBounds(100, 20, 165, 25);
		panel.add(ssnText);
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
		JLabel l = new JLabel("Please enter the verification code that was sent in your email");
		l.setBounds(10, 20, 80, 25);
		panel.add(l);
		JTextField codeText = new JTextField(5);
		codeText.setBounds(100, 20, 165, 25);
		panel.add(codeText);
		next.addActionListener(new NextActionAlert3(codeText));
		frame4.setVisible(true);
	}
}
