package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.Bill;
import com.comtrade.domain.Ingredients;
import com.comtrade.domain.Orders;
import com.comtrade.domain.User;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListOfBillsFinalForm extends JFrame {

	private JPanel contentPane;
	protected OrderForm orderform;
	private JTable table;
	private DefaultTableModel dtm1 = new DefaultTableModel();
	private List <Bill> listOfBills = null;
	int tblNumber = 0;
	public  List<Orders> orders1 = new ArrayList<>();
	User user;
	public double price;

	public ListOfBillsFinalForm(Bill bill, User user, Double price, List<Orders>orders1 )  throws ClassNotFoundException, IOException, InterruptedException {
		this.user = user;
		this.price = price;
		this.orders1 = orders1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(26, 82, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("Bill status:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(26, 193, 88, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 678, 286);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm1);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Discounts:");
		lblNewLabel_3.setBounds(26, 128, 88, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NO DISCOUNTS APPLIED");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(124, 127, 271, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pay type:");
		lblNewLabel_5.setBounds(26, 168, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cash");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(145, 167, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblTime = new JLabel("");
		lblTime.setBounds(193, 330, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblNewLabel_2 = new JLabel("Paid");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(145, 192, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase order details:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(34, 31, 174, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("Date of issue:");
		lblNewLabel_7.setBounds(26, 103, 78, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tableNumber = tblNumber;
				Orders orders5 = new Orders(1,tableNumber,price,1);
				orders1.add(orders5);
				double price = 0;
				for(int i = 0; i < orders1.size()-1;i++) {
					price+=orders1.get(i).getPrice();
				}
				
				int idRestaurant = 1;
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis());
				String timez = formatter.format(date);
				String waitersFirstName = user.getFirst_name();
				Bill bill = new Bill(waitersFirstName,idRestaurant,price,tableNumber,timez);
				try {
					TransferClass transferClass1 = ControllerUI.getControllerUI().execute(TransferClass.create(bill, ConstUI.BILL, ConstBL.ADDBILL));
					JOptionPane.showMessageDialog(null, "You've succesfully closed your bill.");
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
				finally {
					try {
						showAllBillsInTable(bill);
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
				
				
				
			}
		});
		btnNewButton.setBounds(470, 78, 89, 23);
		contentPane.add(btnNewButton);
		//orderform.fillTable(String quantity1,String comboBoxType);
		Object[] columns = {"Table number", "Bill time", "ID_Restaurant", "Waiter's name", "Final Amount"};
		dtm1.addColumn(columns[0]);
		dtm1.addColumn(columns[1]);
		dtm1.addColumn(columns[2]);
		dtm1.addColumn(columns[3]);
		dtm1.addColumn(columns[4]);
		showAllBillsInTable(bill);
		//orders1 = new ArrayList<>();
	}
	private void showAllBillsInTable(Bill bill) throws ClassNotFoundException, IOException, InterruptedException {
		TransferClass transferClass = TransferClass.create(1, ConstUI.BILL, ConstBL.RETURN_ALL_BILLS);
		listOfBills = (List<Bill>) ControllerUI.getControllerUI().execute(transferClass).getResponse();
		dtm1.setRowCount(0);
		for (Bill bill1 : listOfBills) {
			Object[] columns = {bill1.getid_restaurantTable(),bill1.getDateTime() ,bill1.getIdRestaurant(), bill1.getWaiterName(),
					bill1.getFinalAmount()+ " $"};
			dtm1.addRow(columns);
		}

	}
}