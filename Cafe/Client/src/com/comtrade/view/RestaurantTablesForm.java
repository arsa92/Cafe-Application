package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.comtrade.constants.ConstBL;
import com.comtrade.constants.ConstImages;
import com.comtrade.constants.ConstUI;
import com.comtrade.controllerFront.ControllerUI;
import com.comtrade.domain.Offers;
import com.comtrade.domain.RestaurantTable;
import com.comtrade.domain.Restaurants;
import com.comtrade.domain.User;

import com.comtrade.transfer.TransferClass;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class RestaurantTablesForm extends JFrame {

	private JPanel contentPane;
	private List<Offers> menuList = new ArrayList<>();
	private List<JButton> buttonList = new ArrayList<>();
	private Restaurants restaurant;
	private User user;
	private List<RestaurantTable>nonBusyTables = new ArrayList<>();
	private RestaurantTable restaurantTable;
	private JLabel lblNewLabel;
	private JTextField tfTableNumber;
	private JButton btnCreateTables;
	private JLabel lblNumberTable;
	

	public RestaurantTablesForm(User user) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Create a new table");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(235, 31, 219, 25);
		contentPane.add(lblNewLabel);
		
		tfTableNumber = new JTextField();
		tfTableNumber.setBounds(368, 78, 86, 20);
		contentPane.add(tfTableNumber);
		tfTableNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Table number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(253, 75, 109, 23);
		contentPane.add(lblNewLabel_1);
		
		btnCreateTables = new JButton("Create Table Number");
		btnCreateTables.setForeground(new Color(128, 0, 0));
		btnCreateTables.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCreateTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tableNumber = Integer.parseInt(tfTableNumber.getText());
				RestaurantTable restaurantTable = new RestaurantTable();
				restaurantTable.setTable_number(tableNumber);
				
				try {
					TransferClass transferClass = null;
					try {
						transferClass = ControllerUI.getControllerUI()
								.execute(TransferClass.create(restaurantTable, ConstUI.RESTAURANT_TABLE, ConstBL.POST));
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"A table with table #(number) "+ tfTableNumber.getText()+" has been created." + "\n" +"To remove a table, please purchase the PRO version.");	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCreateTables.setBounds(273, 129, 161, 23);
		contentPane.add(btnCreateTables);
		
		lblNumberTable = new JLabel("");
		lblNumberTable.setBounds(419, 127, 46, 14);
		contentPane.add(lblNumberTable);
		lblNumberTable.setText(tfTableNumber.getText());
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 715, 546);
		//Image img = new ImageIcon(this.getClass().getResource("C:\\Users\\arsa9\\Desktop\\Projekti\\cafe\\img\\tablez.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon("C:\\\\Users\\\\arsa9\\\\Desktop\\\\Projekti\\\\cafe\\\\img\\\\tablez.jpg"));
		contentPane.add(lblNewLabel_3);
		
		//list of restaurants has to be returned from managerform with user parameter?
		this.user = user;
		//restaurants equals to restaurants that are found first ???
		buttonList = attachButtonsToList();
    }

    private List<JButton> attachButtonsToList() {
        return buttonList;
    }

    public static RestaurantTable returnRestaurantTable(int table_number, int id_restaurant) throws Exception 
    	{
    	RestaurantTable returnRestaurantTable = new RestaurantTable(table_number, id_restaurant);
        TransferClass transferClass = TransferClass.create(returnRestaurantTable, ConstUI.RESTAURANT, ConstBL.RETURN_RESTAURANT_TABLE);
        try 
        {
        	returnRestaurantTable = (RestaurantTable) ControllerUI.getControllerUI().execute(transferClass).getResponse();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return returnRestaurantTable;
    }
    
    private void setColours() throws Exception {

        TransferClass transferClass = TransferClass.create(null, ConstUI.RESTAURANT, ConstBL.RETURN_AVAILABLE_TABLES);
        try {
        	nonBusyTables = (List<RestaurantTable>) ControllerUI.getControllerUI().execute(transferClass).getResponse();
        } catch (IOException | InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (JButton button : buttonList) {
            Image buttonPhoto = new ImageIcon(ConstImages.AVAILABLE_TABLE.imageAvailableTable()).getImage();
            button.setIcon((Icon) buttonPhoto);
        }
        if (nonBusyTables.size()>0){
            for (RestaurantTable table: nonBusyTables) {
                if (table.getId_restaurant() == restaurant.getId_restaurant()) {

                    for (int i = 0; i <buttonList.size() ; i++) {
                        if (table.getTable_number() == (i+1)){
                            Image buttonPhoto = new ImageIcon(ConstImages.BUSY_TABLE.imageBusyTable()).getImage();
                            buttonList.get(i).setIcon((Icon) buttonPhoto);
                        }
                    }
                }
            }
        }
    }
	}

