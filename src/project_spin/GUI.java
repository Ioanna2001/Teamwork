package project_spin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class GUI {
	static 		JRadioButton c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,c11, c12, c13;
	static JFrame frame = null;
	static JFrame frame1 = null;
	static JFrame frame2 = null;
	static JFrame frame3 = null;
	static JTextField nameText;
	static JTextField emailText;
	static JTextField ssnText;
	static JTextField fcText;
	static JFrame frame4 = null;
	static JTextField codeText;
	static JFrame frame5 = null;
	static JFrame frame6 = null;
	static JSpinner spinner;
	static JFrame frame7 = null;
	static JFrame frame8 = null;
	static JFrame frameFc = null;
	static JFrame frameC = null;
	static JTextField contactName;
	static JTextField contactEmail;
	static JButton finish;
	static JButton add;
	static JFrame frameM =null;

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
		if (frame != null)
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
		if (frame2 != null)
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
		if (frame1 != null)
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
		if (frame3 != null)
			frame3.setVisible(false);
		frame4 = new JFrame("Verify Code");
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setSize(350, 200);
		JPanel panel = new JPanel();
		frame4.add(panel);
		panel.setLayout(null);
		JLabel l = new JLabel("Code");
		l.setBounds(20, 20, 150, 20);
		panel.add(l);
		JLabel label = new JLabel("Enter the verification code that was sent in your email");
		label.setLocation(10, 50);
		label.setSize(700, 25);
		panel.add(label);
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
		if (frame4 != null)
			frame4.setVisible(false);
		frame5 = new JFrame("Location");
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setSize(600, 800);
		frame5.setResizable(true);
		JPanel panel = new JPanel();
		frame5.add(panel);
		panel.setLayout(null);
		JLabel l=new JLabel("Choose location:");  
		l.setBounds(20, 30, 150, 50);  
		c1 = new JRadioButton("Eastern Macedonia and Thrace");
		c1.setBounds(150, 30, 500, 50);
		c2 = new JRadioButton("Central Macedonia");
		c2.setBounds(150, 70, 500, 50);
		c3 = new JRadioButton("West Macedonia");
		c3.setBounds(150, 110, 500, 50);
		c4 = new JRadioButton("Epirus");
		c4.setBounds(150, 150, 500, 50);
		c5 = new JRadioButton("Thessaly");
		c5.setBounds(150, 190, 500, 50);
		c6 = new JRadioButton("Ionian Islands");
		c6.setBounds(150, 230, 500, 50);
		c7 = new JRadioButton("West Greece");
		c7.setBounds(150, 270, 500, 50);
		c8 = new JRadioButton("Central Greece");
		c8.setBounds(150, 310, 500, 50);
		c9 = new JRadioButton("Attica");
		c9.setBounds(150, 350, 500, 50);
		c10 = new JRadioButton("Peloponnese");
		c10.setBounds(150, 390, 500, 50);
		c11 = new JRadioButton("North Aegean");
		c11.setBounds(150, 430, 500, 50);
		c12 = new JRadioButton("South Aegean");
		c12.setBounds(150, 470, 500, 50);
		c13 = new JRadioButton("Crete");
		c13.setBounds(150, 510, 500, 50);
		ButtonGroup group = new ButtonGroup();
		panel.add(l);
		group.add(c1);
		group.add(c2);
		group.add(c3);
		group.add(c4);
		group.add(c5);
		group.add(c6);
		group.add(c7);
		group.add(c8);
		group.add(c9);
		group.add(c10);
		group.add(c11);
		group.add(c12);
		group.add(c13);
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
		if (frame5 != null)
			frame5.setVisible(false);
		frame6 = new JFrame("Age");
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.setSize(350, 200);
		JPanel panel = new JPanel();
		frame6.add(panel);
		panel.setLayout(null);
		SpinnerModel value = new SpinnerNumberModel(0, 0, 99, 1);
		spinner = new JSpinner(value);
		spinner.setBounds(10, 35, 50, 30);
		panel.add(spinner);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		JLabel label = new JLabel("Enter your age");
		label.setBounds(10, 10, 100, 25);
		panel.add(label);
		panel.add(next);
		next.addActionListener(new NextActionAlert5());
		frame6.setVisible(true);
	}

	static void gui8() {
		frame7 = new JFrame("Symptoms");
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.setSize(600, 800);
		frame7.setResizable(true);
		JPanel panel = new JPanel();
		frame7.add(panel);
		panel.setLayout(null);
		JLabel l=new JLabel("Peak your sympotoms:");  
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
		next.addActionListener(new NextActionAlert6());
		frame7.setVisible(true);
	}

	static void warning() {
		frame7.setVisible(false);
		frame8 = new JFrame("Warning!");
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.setSize(350, 200);
		JOptionPane.showMessageDialog(frame8, "Your symptoms are alarming."
				+ " Please consider getting tested for Covid-19");
		frame8.setVisible(true);
	}
		static void guiFc() {
		frame1.setVisible(false);
		frameFc = new JFrame("Please assign the password you recenied in your e-mail");
		frameFc.setSize(350, 200);
		frameFc.setResizable(false);
		frameFc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelFc = new JPanel();
		frameFc.add(panelFc);
		panelFc.setLayout(null);
		JLabel FcLabel = new JLabel("Password");
		FcLabel.setBounds(10, 20, 80, 25);
		panelFc.add(FcLabel);
		fcText = new JTextField(10000);
		fcText.setBounds(100, 20, 165, 25);
		panelFc.add(fcText);
		JButton next = new JButton("Next");
		next.setBounds(10, 80, 80, 25);
		panelFc.add(next);
		next.addActionListener(new NextActionAlertFc());
		frameFc.setVisible(true);
	}

		static void guiAddContacts() {
			if (frameFc != null) {
				frameFc.setVisible(false);
			}
			if (frame8 != null) {
				frame8.setVisible(false);
			}
			if (frame7 != null) {
				frame7.setVisible(false);
			}
			if (AddAlert.frame != null) {
				AddAlert.frame.setVisible(false);
			}
			frameC = new JFrame("Add Contacts");
			frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameC.setSize(500, 400);
			frameC.setResizable(true);
			JPanel panel = new JPanel();
			panel.setLayout(null);
			frameC.add(panel);
			JLabel l1 = new JLabel("Add the email and name of your close contacts:");
			JLabel l2 = new JLabel("-People you have been fifteen or less meters apart");
			JLabel l3 = new JLabel("-People you have been in the same room for two hours or more");
			l1.setBounds(10, 10, 800, 50);
			l2.setBounds(10, 60, 800, 50);
			l3.setBounds(10, 110, 800, 50);
			panel.add(l1);
			panel.add(l2);
			panel.add(l3);
			contactName = new JTextField(100);
			contactName.setBounds(100, 200, 165, 25);
			contactEmail = new JTextField(100);
			contactEmail.setBounds(100, 250, 165, 25);
			JLabel emailLabel = new JLabel("Email");
			emailLabel.setBounds(10, 250, 300, 25);
			panel.add(emailLabel);
			JLabel nameLabel = new JLabel("Name");
			nameLabel.setBounds(10, 200, 300, 25);
			panel.add(nameLabel);
			panel.add(contactEmail);
			panel.add(contactName);
			add = new JButton("Add Contact");
			add.setBounds(200, 300, 150, 25);
			finish = new JButton("Finish");
			finish.setBounds(100, 300, 80, 25);
			panel.add(finish);
			panel.add(add);
			add.addActionListener(new AddAlert());
			finish.addActionListener(new AddAlert());
			frameC.setVisible(true);
		}

	static void guiMenu() {
	//	frameC.setVisible(false);
		frameM = new JFrame("Option Menu");
		frameM.setSize(450, 200);
		frameM.setResizable(true);
		frameM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frameM.add(panel);
		panel.setLayout(null);
		JLabel label = new JLabel("Select one of the options to edit your information or Finish to exit:");
		label.setBounds(10, 10,800, 50);
		panel.add(label);
		JButton option1 = new JButton("Edit Contacts");
		option1.setBounds(10, 45, 150, 25);
		panel.add(option1);
		JButton option2 = new JButton("Edit Symptoms");
		option2.setBounds(10, 80, 150, 25);
		panel.add(option2);
		if (Corona.getStatus().equals("C")) {
			JButton option3 = new JButton("Set status to cured");
			option3.setBounds(10, 115, 150, 25);
			panel.add(option3);
			option3.addActionListener(new Option3Alert());
		}
		JButton finish = new JButton("Finish");
		finish.setBounds(200, 115, 80, 25);
		panel.add(finish);
		option1.addActionListener(new Option1Alert());
		option2.addActionListener(new Option2Alert());
		finish.addActionListener(new ExitAlert());
		frameM.setVisible(true);
	}
}
