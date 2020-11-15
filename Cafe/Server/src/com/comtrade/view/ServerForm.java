package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.threads.RealTimeClockThread;
import com.comtrade.threads.ServerThread;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ServerForm extends JFrame {

	private JPanel contentPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForm frame = new ServerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		JLabel lblWatch = new JLabel("Process Timer");
		lblWatch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWatch.setForeground(Color.WHITE);
		lblWatch.setBounds(156, 75, 105, 25);
		contentPane1.add(lblWatch);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ServerThread serverThread = new ServerThread();
				serverThread.start();
				RealTimeClockThread clockThread = new RealTimeClockThread(lblWatch);
			}
		});
		btnNewButton.setBounds(131, 111, 162, 23);
		contentPane1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-64, -135, 450, 277);
		contentPane1.add(lblNewLabel);
		//Image img = new ImageIcon(this.getClass().getResource("/server.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\server.png"));
		lblNewLabel.setBounds(0, 0, 706, 556);
		
	
	}
}