package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.User;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistrationForm extends JFrame {

	private JPanel lblConfirmPassword;
	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfUsername;
	private JTextField tfRole;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 587);
		lblConfirmPassword = new JPanel();
		lblConfirmPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lblConfirmPassword);
		lblConfirmPassword.setLayout(null);
		
		lblNewLabel_1 = new JLabel("You may only register as a:");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(60, 403, 161, 14);
		lblConfirmPassword.add(lblNewLabel_1);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(213, 131, 167, 31);
		lblConfirmPassword.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(213, 197, 167, 26);
		lblConfirmPassword.add(tfUsername);
		
		
		tfRole = new JTextField();
		tfRole.setForeground(new Color(128, 0, 0));
		tfRole.setText("        waiter");
		tfRole.setOpaque(false);
		tfRole.setColumns(10);
		tfRole.setBounds(218, 400, 90, 20);
		tfRole.setEditable(false);
		lblConfirmPassword.add(tfRole);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 259, 167, 26);
		lblConfirmPassword.add(passwordField);
		
		JButton btnRegistration = new JButton("");
		btnRegistration.setOpaque(false);
		btnRegistration.setContentAreaFilled(false);
		btnRegistration.setBorderPainted(false);
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.copyValueOf(passwordField.getPassword());
				String firstName = tfFirstName.getText();
				String username = tfUsername.getText();
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setFirst_name(firstName);
					user.setRoleName(tfRole.getText());
				
					try {
						try {
							TransferClass transferClass = ControllerUI.getControllerUI().execute(
									TransferClass.create(user,ConstUI.USER,ConstBL.POST));
												
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "You have succesfully registered.");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		}});
		
		btnRegistration.setBounds(188, 314, 118, 49);
		lblConfirmPassword.add(btnRegistration);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(100, 149, 237));
		//lblNewLabel.setBounds(0, 0, 511, 548);
		lblConfirmPassword.add(lblNewLabel);
		//Image img = new ImageIcon(this.getClass().getResource("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\register.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\arsa9\\\\Desktop\\\\Projekti\\\\cafe\\\\img\\\\register.png"));
		lblNewLabel.setBounds(0, 0, 706, 556);

		
		
	
}
}
