package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.List;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

public class SwingLogin extends JFrame implements ActionListener {
	// Attributes
	private static final long serialVersionUID = 1L;
	private JPanel loginPanel, registerPanel, panelMN, panelM1, panelM3;
	private JLabel labelLogin, labelRegister, labelNote, labelUser, labelPass, labelRePass, labelM1, labelCopyright;
	private JTextField user, pass, repass, reguser, regpass;
	private JButton createUser, login, register, loginInReG, printList, addUser, delUser, showApp, unlock, lock, logout;
	private JMenuBar barmenu;
	private JMenu menuOption, menuUser, menuHelp;
	private JMenuItem itemExit, itemAbout, itemLogin, itemRegister, itemPrintList, itemAddUser, itemDelUser,
			itemShowApp, itemUnlock, itemLock, itemLogout, itemNonRoot;
	private LoginSystem loginsystem;
	private ExamTest testExam;
	private int countWrong = 0, countWrong2 = 0;

	// Constructor
	public SwingLogin() throws HeadlessException {
		super();
		setSize(550, 325);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setTitle("Login");
		setResizable(false);
		ImageIcon icon = new ImageIcon("image/icon.jpg");
		setIconImage(icon.getImage());
		// UI LOGIN
		loginPanel = new JPanel();
		loginPanel.setLayout(new GridLayout(6, 1, 10, 10));
		labelLogin = new JLabel("LOGIN");
		labelLogin.setFont(labelLogin.getFont().deriveFont(18f));
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.yellow);
		panel1.add(labelLogin);
		labelUser = new JLabel("Username");
		labelUser.setFont(labelLogin.getFont().deriveFont(13f));
		user = new JTextField(15);
		user.addActionListener(this);
		JPanel panel2 = new JPanel();
		panel2.add(labelUser);
		panel2.add(user);
		panel2.setBackground(Color.yellow);
		labelPass = new JLabel("Password ");
		labelPass.setFont(labelLogin.getFont().deriveFont(13f));
		pass = new JPasswordField(15);
		pass.addActionListener(this);
		JPanel panel3 = new JPanel();
		panel3.add(labelPass);
		panel3.add(pass);
		panel3.setBackground(Color.yellow);
		login = new JButton("Login");
		login.setBackground(Color.green);
		login.setFont(labelLogin.getFont().deriveFont(13f));
		login.addActionListener(this);
		register = new JButton("Register");
		register.addActionListener(this);
		JPanel panel4 = new JPanel();
		panel4.add(register);
		panel4.add(login);
		panel4.setBackground(Color.yellow);
		labelNote = new JLabel("Note: If you enter wrong password 3 times, application will freeze few seconds!");
		labelNote.setForeground(Color.red);
		labelNote.setFont(labelLogin.getFont().deriveFont(10f));
		JPanel panel0 = new JPanel();
		panel0.add(labelNote);
		panel0.setBackground(Color.yellow);
		labelCopyright = new JLabel("© • Copyright by river0077");
		labelCopyright.setFont(labelLogin.getFont().deriveFont(10f));
		JPanel panel00 = new JPanel();
		panel00.add(labelCopyright);
		panel00.setBackground(Color.yellow);
		loginPanel.add(panel1);
		loginPanel.add(panel2);
		loginPanel.add(panel3);
		loginPanel.add(panel4);
		loginPanel.add(panel0);
		loginPanel.add(panel00);
		loginPanel.setBackground(Color.yellow);
		getContentPane().add(loginPanel);
		getContentPane().setBackground(Color.yellow);
		// UI REGISTER
		registerPanel = new JPanel();
		registerPanel.setLayout(new GridLayout(6, 1, 10, 10));
		labelRegister = new JLabel("REGISTER");
		labelRegister.setFont(labelLogin.getFont().deriveFont(18f));
		JPanel panel5 = new JPanel();
		panel5.add(labelRegister);
		panel5.setBackground(Color.yellow);
		labelUser = new JLabel("Username ");
		labelUser.setFont(labelLogin.getFont().deriveFont(13f));
		reguser = new JTextField(15);
		reguser.addActionListener(this);
		JPanel panel6 = new JPanel();
		panel6.add(labelUser);
		panel6.add(reguser);
		panel6.setBackground(Color.yellow);
		labelPass = new JLabel("Password  ");
		labelPass.setFont(labelLogin.getFont().deriveFont(13f));
		regpass = new JPasswordField(15);
		regpass.addActionListener(this);
		JPanel panel7 = new JPanel();
		panel7.add(labelPass);
		panel7.add(regpass);
		panel7.setBackground(Color.yellow);
		labelRePass = new JLabel("RePassword");
		labelRePass.setFont(labelLogin.getFont().deriveFont(13f));
		repass = new JPasswordField(15);
		repass.addActionListener(this);
		JPanel panel8 = new JPanel();
		panel8.add(labelRePass);
		panel8.add(repass);
		panel8.setBackground(Color.yellow);
		loginInReG = new JButton("Login");
		loginInReG.addActionListener(this);
		JPanel panel9 = new JPanel();
		createUser = new JButton("Create");
		createUser.setBackground(Color.blue);
		createUser.setFont(labelLogin.getFont().deriveFont(13f));
		createUser.addActionListener(this);
		panel9.add(loginInReG);
		panel9.add(createUser);
		panel9.setBackground(Color.yellow);
		JPanel panel10 = new JPanel();
		labelCopyright = new JLabel("© • Copyright by river0077");
		panel10.add(labelCopyright);
		panel10.setBackground(Color.yellow);
		registerPanel.add(panel5);
		registerPanel.add(panel6);
		registerPanel.add(panel7);
		registerPanel.add(panel8);
		registerPanel.add(panel9);
		registerPanel.add(panel10);
		registerPanel.setBackground(Color.yellow);
		// UI MANAGEMENT
		panelM1 = new JPanel();
		panelM1.setSize(300, 200);
		panelM1.setBorder(BorderFactory.createLineBorder(Color.black));
		labelM1 = new JLabel();
		panelM1.setBackground(Color.pink);
		labelM1.setFont(labelLogin.getFont().deriveFont(12f));
		panelM1.add(labelM1);
		panelM3 = new JPanel();
		printList = new JButton("Print List");
		printList.setBackground(Color.gray);
		printList.setFont(labelLogin.getFont().deriveFont(10.5f));
		printList.addActionListener(this);
		addUser = new JButton("Add User");
		addUser.setBackground(Color.green);
		addUser.setFont(labelLogin.getFont().deriveFont(10.5f));
		addUser.addActionListener(this);
		delUser = new JButton("Delete User");
		delUser.setBackground(Color.red);
		delUser.setFont(labelLogin.getFont().deriveFont(10.5f));
		delUser.addActionListener(this);
		showApp = new JButton("Show App");
		showApp.setBackground(Color.blue);
		showApp.setFont(labelLogin.getFont().deriveFont(10.5f));
		showApp.addActionListener(this);
		unlock = new JButton("Unlock");
		unlock.setBackground(Color.pink);
		unlock.setFont(labelLogin.getFont().deriveFont(10.5f));
		unlock.addActionListener(this);
		lock = new JButton("Lock");
		lock.setBackground(Color.red);
		lock.setFont(labelLogin.getFont().deriveFont(10.5f));
		lock.addActionListener(this);
		logout = new JButton("Logout");
		logout.setBackground(Color.orange);
		logout.setFont(labelLogin.getFont().deriveFont(10.5f));
		logout.addActionListener(this);
		panelM3.add(printList);
		panelM3.add(addUser);
		panelM3.add(delUser);
		panelM3.add(showApp);
		panelM3.add(unlock);
		panelM3.add(lock);
		panelM3.add(logout);
		panelM3.setBackground(Color.yellow);
		JPanel panelLoading = new JPanel();
		panelLoading.setBackground(Color.yellow);
		JLabel labelLoading = new JLabel("");
		panelLoading.add(labelLoading);
		JPanel panel001 = new JPanel();
		labelCopyright = new JLabel("© • Copyright by river0077");
		panel001.add(labelCopyright);
		panel001.setBackground(Color.yellow);
		// Menu
		barmenu = new JMenuBar();
		menuOption = new JMenu("Option");
		menuUser = new JMenu("User");
		itemNonRoot = new JMenuItem("You can not access this!");
		menuUser.add(itemNonRoot);
		itemLogin = new JMenuItem("Login");
		itemLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		ImageIcon iconLogin = new ImageIcon("image/login.png");
		// set size for iconLogin
		iconLogin = new ImageIcon(iconLogin.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemLogin.setIcon(iconLogin);
		itemLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(registerPanel);
				getContentPane().remove(panelMN);
				getContentPane().add(loginPanel);
				user.setText("");
				pass.setText("");
				setTitle("Login");
				revalidate();
				repaint();
			}
		});
		itemRegister = new JMenuItem("Register");
		itemRegister.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		// set size for iconRegister
		ImageIcon iconRegister = new ImageIcon("image/register.png");
		// set size for iconRegister
		iconRegister = new ImageIcon(iconRegister.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemRegister.setIcon(iconRegister);
		itemRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().remove(loginPanel);
				getContentPane().remove(panelMN);
				getContentPane().add(registerPanel);
				reguser.setText("");
				regpass.setText("");
				repass.setText("");
				setTitle("Register");
				revalidate();
				repaint();
			}
		});
		itemExit = new JMenuItem("Exit");
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		ImageIcon iconExit = new ImageIcon("image/exit.png");
		// set size for iconExit
		iconExit = new ImageIcon(iconExit.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemExit.setIcon(iconExit);
		itemExit.addActionListener(e -> System.exit(0));
		itemPrintList = new JMenuItem("Print List");
		itemPrintList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		ImageIcon iconPrintList = new ImageIcon("image/printlist.png");
		// set size for iconPrintList
		iconPrintList = new ImageIcon(iconPrintList.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemPrintList.setIcon(iconPrintList);
		itemPrintList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printList.doClick();
				itemPrintList.setText("Reload");
			}
		});
		itemAddUser = new JMenuItem("Add User");
		itemAddUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		ImageIcon iconAddUser = new ImageIcon("image/add.png");
		// set size for iconAddUser
		iconAddUser = new ImageIcon(iconAddUser.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemAddUser.setIcon(iconAddUser);
		itemAddUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUser.doClick();
			}
		});
		itemDelUser = new JMenuItem("Delete User");
		itemDelUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		ImageIcon iconDelUser = new ImageIcon("image/delete.png");
		// set size for iconDelUser
		iconDelUser = new ImageIcon(iconDelUser.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemDelUser.setIcon(iconDelUser);
		itemDelUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delUser.doClick();
			}
		});
		itemShowApp = new JMenuItem("Show App");
		itemShowApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		ImageIcon iconShowApp = new ImageIcon("image/showapp.png");
		// set size for iconShowApp
		iconShowApp = new ImageIcon(iconShowApp.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemShowApp.setIcon(iconShowApp);
		itemShowApp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showApp.doClick();
			}
		});
		itemUnlock = new JMenuItem("Unlock");
		itemUnlock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		ImageIcon iconUnlock = new ImageIcon("image/unlock.png");
		// set size for iconUnlock
		iconUnlock = new ImageIcon(iconUnlock.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemUnlock.setIcon(iconUnlock);
		itemUnlock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unlock.doClick();
			}
		});
		itemLock = new JMenuItem("Lock");
		itemLock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		ImageIcon iconLock = new ImageIcon("image/lock.png");
		// set size for iconLock
		iconLock = new ImageIcon(iconLock.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemLock.setIcon(iconLock);
		itemLock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lock.doClick();
			}
		});
		itemLogout = new JMenuItem("Logout");
		itemLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		ImageIcon iconLogout = new ImageIcon("image/logout.png");
		// set size for iconLogout
		iconLogout = new ImageIcon(iconLogout.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemLogout.setIcon(iconLogout);
		itemLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				logout.doClick();
			}
		});
		menuOption.add(itemLogin);
		menuOption.add(itemRegister);
		menuOption.add(itemExit);
		menuHelp = new JMenu("Help");
		itemAbout = new JMenuItem("About");
		ImageIcon iconAbout = new ImageIcon("image/about.png");
		// set size for iconAbout
		iconAbout = new ImageIcon(iconAbout.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		itemAbout.setIcon(iconAbout);
		itemAbout.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Developed by river0077.");
		});
		menuHelp.add(itemAbout);
		barmenu.add(menuOption);
		barmenu.add(menuUser);
		barmenu.add(menuHelp);
		setJMenuBar(barmenu);
		panelMN = new JPanel();
		panelMN.setLayout(new BorderLayout());
		panelMN.add(panelM1, BorderLayout.CENTER);
		panelMN.add(panelM3, BorderLayout.NORTH);
		panelMN.add(labelLoading, BorderLayout.SOUTH);
		panelMN.add(panel001, BorderLayout.PAGE_END);

		setVisible(true);
		// Data
		loginsystem = new LoginSystem();
		loginsystem.addUser(new User<String, String>("root", "admin", 0.0, null), false);
		loginsystem.addUser(new User<String, String>("giang", "0077", 0.0, null), false);
		loginsystem.addUser(new User<String, String>("hitler", "1945", 0.0, null), false);
	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == register) {
			getContentPane().remove(loginPanel);
			getContentPane().add(registerPanel);
			reguser.setText("");
			regpass.setText("");
			repass.setText("");
			setTitle("Register");
			revalidate();
			repaint();
		} else if (e.getSource() == loginInReG) {
			getContentPane().remove(registerPanel);
			getContentPane().add(loginPanel);
			user.setText("");
			pass.setText("");
			setTitle("Login");
			revalidate();
			repaint();
		} else if (e.getSource() == login || e.getSource() == pass || e.getSource() == user) {
			String username = user.getText();
			String password = pass.getText();
			if (loginsystem.authenticate(username, password)) {
				if (username.equals("root")) {
					System.out.println("logined successfully as root");
					JOptionPane.showMessageDialog(this, "LOGIN AS ROOT");
					countWrong = 0;
					getContentPane().remove(loginPanel);
					getContentPane().remove(registerPanel);
					menuUser.remove(itemNonRoot);
					menuUser.add(itemPrintList);
					menuUser.add(itemAddUser);
					menuUser.add(itemDelUser);
					menuUser.add(itemShowApp);
					menuUser.add(itemUnlock);
					menuUser.add(itemLock);
					menuUser.add(itemLogout);
					getContentPane().add(panelMN);
					setTitle("Managerment");
					revalidate();
					repaint();
				} else {
					for (User<String, String> u : loginsystem.getUserList()) {
						if (u.getUser().equals(username)) {
							if (u.getStatus() == "PASS" || u.getStatus() == "FAIL" || u.getStatus() == "CHEAT") {
								JOptionPane.showMessageDialog(this, "YOU HAVE TAKEN THE EXAM! AUTO LOG OUT!");
								System.out.println("Logout - User: " + username + "(auto log out)");
								user.setText("");
								pass.setText("");
								return;
							} else if (u.getStatus() == "LOCKED") {
								JOptionPane.showMessageDialog(this,
										"YOUR ACCOUNT HAS BEEN LOCKED! PLEASE CONTACT ADMIN!");
								System.out.println("Login - User: " + username + " Fail! (account locked)");
								user.setText("");
								pass.setText("");
								return;
							}
						}
					}
					JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFULLY");
					System.out.println("Login - User: " + username + " (logined successfully)");
					countWrong = 0;
					user.setText("");
					pass.setText("");
					ExamTest exam = new ExamTest();
					exam.setUserName(username);
					exam.setTitle("Thi - User: " + username);
					exam.setVisible(true);
					exam.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							for (User<String, String> u : loginsystem.getUserList()) {
								if (u.getUser().equals(username)) {
									u.setScore(exam.getScore());
									u.setStatus(exam.getStatus());
								}
							}
						}
					});
				}
			} else {
				if (loginsystem.wrongPass(username, password)) {
					JOptionPane.showMessageDialog(this, "WRONG PASSWORD");
					System.out.println("Login - User: " + username + " Fail! (wrong password)");
					countWrong++;
					if (countWrong == 3) {
						JOptionPane.showMessageDialog(this,
								"YOU HAVE ENTERED WRONG PASSWORD 3 TIMES. APPLICATION WILL FREEZE FEW SECOND!");
						System.out.println("Login - User: " + username + " Fail! (freeze 5 seconds)");
						countWrong = 0;
						countWrong2++;
						wait(5000);
					}
					if (countWrong2 == 3) {
						System.out.println("Login - User: " + username + " Fail! (account locked)");
						JOptionPane.showMessageDialog(this, "YOUR ACCOUNT HAS BEEN LOCKED! PLEASE CONTACT ADMIN!");
						countWrong2 = 0;
						for (User<String, String> u : loginsystem.getUserList()) {
							if (u.getUser().equals(username)) {
								u.setStatus("LOCKED");
								return;
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "NOT FOUND ACCOUNT. Check your username again!");
				}
			}
		} else if (e.getSource() == createUser || e.getSource() == regpass || e.getSource() == reguser
				|| e.getSource() == repass) {
			String username = reguser.getText();
			String password = regpass.getText();
			if (username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(this, "PLEASE ENTER CHARACTERS");
				return;
			}
			if (!password.equals(repass.getText())) {
				JOptionPane.showMessageDialog(this, "PASSWORDS DO NOT MATCH!");
				return;
			}
			for (User<String, String> u : loginsystem.getUserList()) {
				if (u.getUser().equals(username)) {
					JOptionPane.showMessageDialog(this, "USERNAME ALREADY EXISTS!");
					return;
				}
			}
			loginsystem.addUser(new User<String, String>(username, password, 0.0, null), false);
			System.out.println("Register - User: " + username + " (registered successfully)");
			JOptionPane.showMessageDialog(this, "REGISTER SUCCESSFULLY");
			getContentPane().remove(registerPanel);
			getContentPane().add(loginPanel);
			user.setText("");
			pass.setText("");
			revalidate();
			repaint();
		} else if (e.getSource() == printList) {
			printList.setText("Reload");
			SwingWorker<Void, String> worker = new SwingWorker<>() {
				@Override
				protected Void doInBackground() throws Exception {
					StringBuilder load = new StringBuilder();
					for (int i = 0; i < 80; i++) {
						load.append("|");
						publish(load.toString());
						Thread.sleep(5);
					}
					return null;
				}

				@Override
				protected void process(List<String> chunks) {
					String latest = chunks.get(chunks.size() - 1);
					labelM1.setText(latest);
				}

				@Override
				protected void done() {
					StringBuilder sb = new StringBuilder("<html><b>User -|- Pass -|- Score -|- Status</b><br>");
					for (User<String, String> u : loginsystem.getUserList()) {
						sb.append(u.getUser()).append(" -|- ").append(u.getPass()).append(" -|- ").append(u.getScore())
								.append(" -|- ").append(u.getStatus()).append("<br>");
					}
					sb.append("</html>");
					labelM1.setText(sb.toString());
				}
			};

			worker.execute();
		} else if (e.getSource() == addUser) {
			String username = JOptionPane.showInputDialog(this, "Enter username:");
			if (username == null || username.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "PLEASE ENTER CHARACTERS");
				return;
			}
			String password = JOptionPane.showInputDialog(this, "Enter password:");
			if (password == null || password.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this, "PLEASE ENTER CHARACTERS");
				return;
			}
			loginsystem.addUser(new User<String, String>(username, password, 0.0, null), true);
			printList.doClick();
		} else if (e.getSource() == delUser) {
			String username = JOptionPane.showInputDialog(this, "Enter username to delete:");
			System.out.println("Delete User - User: " + username + " (deleted successfully)");
			loginsystem.deleteUser(username);
			printList.doClick();
		} else if (e.getSource() == showApp) {
			testExam = new ExamTest();
			testExam.setTitle("Thi - User: root");
			testExam.setVisible(true);
			testExam.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					for (User<String, String> u : loginsystem.getUserList()) {
						if (u.getUser().equals("root")) {
							u.setScore(testExam.getScore());
							u.setStatus(testExam.getStatus());
						}
					}
				}
			});
		} else if (e.getSource() == logout) {
			System.out.println("Logout - User: root (log out)");
			JOptionPane.showMessageDialog(this, "LOGOUT SUCCESSFULLY");
			getContentPane().remove(panelMN);
			getContentPane().add(loginPanel);
			menuUser.remove(itemPrintList);
			menuUser.remove(itemAddUser);
			menuUser.remove(itemDelUser);
			menuUser.remove(itemShowApp);
			menuUser.remove(itemUnlock);
			menuUser.remove(itemLock);
			menuUser.remove(itemLogout);
			menuUser.add(itemNonRoot);
			setTitle("Login");
			user.setText("");
			pass.setText("");
			revalidate();
			repaint();
		} else if (e.getSource() == unlock) {
			String username = JOptionPane.showInputDialog(this, "Enter username to unlock:");
			for (User<String, String> u : loginsystem.getUserList()) {
				if (u.getUser().equals(username)) {
					if (u.getStatus() == null) {
						JOptionPane.showMessageDialog(this, "ACCOUNT IS NOT LOCKED");
						System.out.println("Unlock - User: " + username + " (not locked)");
						return;
					} else {
						u.setStatus(null);
						JOptionPane.showMessageDialog(this, "UNLOCKED SUCCESSFULLY");
						System.out.println("Unlock - User: " + username + " (unlocked successfully)");
						printList.doClick();
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "NOT FOUND ACCOUNT");
		} else if (e.getSource() == lock) {
			String username = JOptionPane.showInputDialog(this, "Enter username to lock:");
			for (User<String, String> u : loginsystem.getUserList()) {
				if (u.getUser().equals(username)) {
					if (u.getStatus() != null) {
						JOptionPane.showMessageDialog(this, "ACCOUNT IS NOT LOCKED OR ALREADY LOCKED");
						System.out.println("Lock - User: " + username + " (not locked or already locked)");
						return;
					} else if (u.getStatus() == null) {
						u.setStatus("LOCKED");
						JOptionPane.showMessageDialog(this, "LOCKED SUCCESSFULLY");
						System.out.println("Lock - User: " + username + " (locked successfully)");
						printList.doClick();
						return;
					}
				}
			}
			JOptionPane.showMessageDialog(this, "NOT FOUND ACCOUNT");
		}
	}

	public void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	// Main
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		new SwingLogin();
	}
}
