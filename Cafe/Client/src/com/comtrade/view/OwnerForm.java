package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.Ingredients;
import com.comtrade.domain.User;

import com.comtrade.transfer.TransferClass;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class OwnerForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtRole;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField txtRestaurant;
	private List <User> listOfUsers = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerForm frame = new OwnerForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public OwnerForm(User user) throws ClassNotFoundException, IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel employeeList = new JLabel("List of all employees");
		employeeList.setForeground(new Color(128, 0, 0));
		employeeList.setFont(new Font("Tahoma", Font.BOLD, 16));
		employeeList.setBounds(262, 34, 189, 36);
		contentPane.add(employeeList);
		
		JButton btnAdd = new JButton("Add an employee");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtFirstName.getText();
				String userName = txtUserName.getText();
				String password = txtPassword.getText();
				String role = txtRole.getText();
				int restaurantNumber = Integer.parseInt(txtRestaurant.getText());
				User user = new User(firstName, userName, password, role, restaurantNumber);
				try {
					TransferClass transferClass = ControllerUI.getControllerUI().execute(
							TransferClass.create(user, ConstUI.USER,ConstBL.POST));
					JOptionPane.showMessageDialog(null, "USER ADDED SUCCESSFULLY");
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "User wasn't added.");
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}finally {
					try {
						showEmployeesInTable(user);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAdd.setBounds(222, 93, 271, 36);
		contentPane.add(btnAdd);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(64, 147, 70, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(64, 175, 70, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(64, 206, 70, 20);
		contentPane.add(txtPassword);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFirstName.setForeground(new Color(128, 0, 0));
		lblFirstName.setBounds(0, 144, 67, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserName.setForeground(new Color(128, 0, 0));
		lblUserName.setBounds(0, 178, 67, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setForeground(new Color(128, 0, 0));
		lblPassword.setBounds(0, 208, 66, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRole.setForeground(new Color(128, 0, 0));
		lblRole.setBounds(0, 240, 46, 14);
		contentPane.add(lblRole);
		
		txtRole = new JTextField();
		txtRole.setColumns(10);
		txtRole.setBounds(64, 237, 70, 20);
		contentPane.add(txtRole);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 146, 556, 354);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		Object [] columns = {"First Name","Id_role","Username","Role","Restaurant"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		
		
		JButton btnTables = new JButton("");
		btnTables.setOpaque(false);
		btnTables.setContentAreaFilled(false);
		btnTables.setBorderPainted(false);
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantTablesForm restaurantTablesForm = null;
				try {
					restaurantTablesForm = new RestaurantTablesForm(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				restaurantTablesForm.setVisible(true);
			}
		});
		
		
		
		btnTables.setBounds(514, 36, 178, 23);
		contentPane.add(btnTables);
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			//	Handler handler = new Handler();
						showEmployeesInTable(user);

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
		
		
		
		
		btnRefresh.setBounds(314, 511, 167, 23);
		contentPane.add(btnRefresh);
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRestaurant.setForeground(new Color(128, 0, 0));
		lblRestaurant.setBounds(0, 268, 75, 14);
		contentPane.add(lblRestaurant);
		
		txtRestaurant = new JTextField();
		txtRestaurant.setBounds(74, 268, 59, 17);
		contentPane.add(txtRestaurant);
		txtRestaurant.setColumns(10);
		
		JButton btnAddIngredient = new JButton("");
		btnAddIngredient.setOpaque(false);
		btnAddIngredient.setContentAreaFilled(false);
		btnAddIngredient.setBorderPainted(false);
		btnAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddIngredients addIngredients = null;
				try {
					addIngredients = new AddIngredients(null);
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
				addIngredients.setVisible(true);
				
			}
		});
		btnAddIngredient.setBounds(503, 76, 189, 28);
		contentPane.add(btnAddIngredient);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 711, 568);
		//Image img = new ImageIcon(this.getClass().getResource("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\admin.img")).getImage();
		lblNewLabel.setIcon(new ImageIcon("C:\\\\Users\\\\arsa9\\\\Desktop\\\\Projekti\\\\cafe\\\\img\\\\admin.img"));
		lblNewLabel.setBounds(0, 0, 706, 556);
		contentPane.add(lblNewLabel);
		showEmployeesInTable(user);
		

	}
	private void setColumns() {
		
	}

	
	private void showEmployeesInTable(User user) throws ClassNotFoundException, IOException, InterruptedException {
		TransferClass transferClass = TransferClass.create(user.getId_user(), ConstUI.USER, ConstBL.RETURN_USERS);
		listOfUsers = (List<User>) ControllerUI.getControllerUI().execute(transferClass).getResponse();
		dtm.setRowCount(0);
		for (User user1 : listOfUsers) {
			Object[] columns = { user1.getUsername(), user1.getIdRoleUser(),user1.getFirst_name() ,user1.getCompanyName(), user1.getRoleName()};
			dtm.addRow(columns);
		}

	}
	 
	private void removeFields() {
		
	}
}
