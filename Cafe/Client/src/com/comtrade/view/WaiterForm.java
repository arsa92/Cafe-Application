package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.RestaurantTable;
import com.comtrade.domain.User;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;

public class WaiterForm extends JFrame {

	private JPanel contentPane;
	List<RestaurantTable> tables = new ArrayList<>();
	int table_number_traveling = 0;
	List<Integer> tableNumberList  = new ArrayList<>();
	RestaurantTable restaurantTableGET = new RestaurantTable();

	public WaiterForm(User user) throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestaurantTables = new JLabel("Select a table to work on");
		lblRestaurantTables.setForeground(new Color(240, 255, 240));
		lblRestaurantTables.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRestaurantTables.setBounds(202, 104, 320, 47);
		contentPane.add(lblRestaurantTables);
		
		JComboBox cbTables = new JComboBox();
		cbTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbTables.setBounds(229, 160, 183, 22);
		contentPane.add(cbTables);
		
		fillInComboBox(cbTables);
		
		JButton btnAccess = new JButton("Start serving the customer");
		btnAccess.setForeground(new Color(128, 0, 0));
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer a =  (Integer) cbTables.getSelectedItem();
				RestaurantTable restaurantTable = new RestaurantTable();
				restaurantTable.setTable_number(a);
				restaurantTableGET.setTable_number(a);
				table_number_traveling = a;
				tableNumberList.add(a);
				String abc = "gejh";
			
						//OrderForm orderForm = new OrderForm(a);
						//orderForm(a).setVisible(true);
						try {
							new OrderForm(a,user).setVisible(true);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		});
		btnAccess.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAccess.setBounds(220, 292, 215, 37);
		contentPane.add(btnAccess);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 663, 518);
		//Image img = new ImageIcon(this.getClass().getResource("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\kafe.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\kafe.jpg"));
		lblNewLabel.setBounds(0, 0, 706, 556);
		contentPane.add(lblNewLabel);
		

	}
	
	private void fillInComboBox(JComboBox cbTables) throws InterruptedException {
		try {
			TransferClass request = null;
			try {
				request = TransferClass.create(null, ConstUI.RESTAURANT_TABLE,ConstBL.GET);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<RestaurantTable> tables = null;
			try {
				List<Object> tablezz = (List<Object>) ControllerUI.getControllerUI().execute(request).getResponse();
				tables = (List<RestaurantTable>) ControllerUI.getControllerUI().execute(request).getResponse();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cbTables.removeAllItems();
			for (Object table : (List<Object>) ControllerUI.getControllerUI().execute(request).getResponse()) {
				cbTables.addItem(table);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}
	
}
