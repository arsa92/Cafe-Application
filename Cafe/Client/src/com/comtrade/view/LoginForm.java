package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import com.comtrade.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.ClientCommunication.ClientCommunication;
import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.User;
import com.comtrade.proxy.Proxy;
import com.comtrade.proxy.ProxyLogin;
import com.comtrade.transfer.TransferClass;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationForm registrationForm = new RegistrationForm();
				registrationForm.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(187, 402, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDontHaveCredentials = new JLabel("Don't have credentials?");
		lblDontHaveCredentials.setBounds(41, 404, 136, 19);
		contentPane.add(lblDontHaveCredentials);
		
		tfUser = new JTextField();
		tfUser.setColumns(10);
		tfUser.setBounds(99, 211, 209, 23);
		tfUser.setOpaque(false); 
		contentPane.add(tfUser); 
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUser.getText();
                String password = String.copyValueOf(pfPass.getPassword());
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                TransferClass transferClass;
                try {
                	transferClass = TransferClass.create(user, ConstUI.USER, ConstBL.GET_LOGIN);
                    Proxy proxy  = new ProxyLogin();
                    user = (User) ControllerUI.getControllerUI().execute(transferClass).getResponse();
                    if (user != null){
                        ClientCommunication.getInstance().setUserID(user.getId_user());
                        proxy.login(user);
                        //dispose();

                    }else {
                        JOptionPane.showMessageDialog(null, "Incorrect username/password combination." + "\n                         " + "Try again.");
                    }

                } catch (IOException a) {
                    a.printStackTrace();
                } catch (ClassNotFoundException a) {
                    a.printStackTrace();
                } catch (InterruptedException a) {
                    a.printStackTrace();
                } catch (InvocationTargetException a) {
                    a.printStackTrace();
                }
				
			}
		});
		btnLogin.setBounds(133, 326, 121, 23);
		contentPane.add(btnLogin);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(99, 245, 209, 23);
		pfPass.setOpaque(false);
		contentPane.add(pfPass);
		
		
		JLabel imgLogin = new JLabel("New label");
		imgLogin.setBounds(0, 0, 470, 483);
		//Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		imgLogin.setIcon(new ImageIcon("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\login.png"));
		contentPane.add(imgLogin);

		
		
	}
}