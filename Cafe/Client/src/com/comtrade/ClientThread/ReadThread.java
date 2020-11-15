package com.comtrade.ClientThread;

import com.comtrade.domain.Orders;
import com.comtrade.domain.User;
import com.comtrade.transfer.TransferClass;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ReadThread implements Callable <TransferClass> {
	
    private JTextArea textArea1;
    private Socket socket;
    private TransferClass transferClass;
    private User user;
    private List<User> listRestaurantStaff = new ArrayList<>();
    private List<Orders> listOrder = new ArrayList<>();
    private int idWaiter;
    private int userID;

    public ReadThread(Socket socket, int userID) {
        this.socket = socket;
        this.userID = userID;
        
    }
    @Override
    public TransferClass call() throws Exception {
            try {
                transferClass = handleMessage(socket, userID);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    try {
                        socket.close();
                } catch (IOException exc) {
                        exc.printStackTrace();
                }
            }
        }return transferClass;
    }

    public TransferClass handleMessage(Socket socket, int idUser) throws IOException, ClassNotFoundException {


        while ((transferClass = (TransferClass) new ObjectInputStream(socket.getInputStream()).readObject())!=null){

            if (transferClass.getMessage() != null && !transferClass.getMessage().isEmpty()) {
                String[] tokens = transferClass.getMessage().split(";");
                if (tokens[0].equalsIgnoreCase("")) {
                    int idSender = Integer.parseInt(tokens[1]);

                    if (idSender != idUser) { break;
                    }
                    break;
                } else if (tokens[0].equalsIgnoreCase("")) {
                    break;
                } else {
                    break;
                }
            } else break;
        }
        return transferClass;
    }
}