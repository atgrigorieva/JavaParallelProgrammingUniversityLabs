package ru.spbstu.telematics.java.client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Chat_Interface extends JFrame{

	private JTextPane chatClientFramet;
	private JButton clientTextEnter;
	private JTextArea chatClientText;
	private String messageClient; /// Сообщение клиента
	private String nameClient = ""; //Имя клиента
	private static final int server_port = 6663; // порт соединения с сервером
	private static final String server_addres = "localhost"; // адрес соединения с сервером
	private Scanner clientMessageIN;
	private PrintWriter clientMessageOUT;
	private Socket clientSocket; // Клиентский сокет
	
	public Chat_Interface(String textName1){
		
		try{
			clientSocket = new Socket(server_addres, server_port);
			clientMessageIN = new Scanner(clientSocket.getInputStream());
			clientMessageOUT = new PrintWriter(clientSocket.getOutputStream());
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		nameClient = textName1;
		JPanel content1 = new JPanel();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosing(WindowEvent event) {
				super.windowClosing(event);
				try{
					clientMessageOUT.println(" (" + new Date().toString()+"): " +"Клиент " + nameClient + " вышел из чата");
					clientMessageOUT.println("exit");
					clientMessageOUT.flush();
					clientMessageOUT.close();
					clientMessageIN.close();
					clientSocket.close();
					} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}

			}

			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
		setTitle("Чат клиента " + nameClient);
	    content1.setLayout(null);
	    setSize(600,505);
	    setLocationRelativeTo(null);	   
        setContentPane(content1);
        
        chatClientFramet = new JTextPane();
        chatClientFramet.setBounds(10, 5, 565, 400);
        content1.add(chatClientFramet);        
        chatClientFramet.setEditable(false);
        
        chatClientText = new JTextArea("Ваше нове сообщение");
        chatClientText.setFont(new Font("Arial", Font.PLAIN, 14));
        chatClientText.setBounds(10, 410, 400, 50);
        content1.add(chatClientText);
        
        clientTextEnter = new JButton("Отправить");
        clientTextEnter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clientTextEnter.setBounds(425, 410, 150, 50);
        content1.add(clientTextEnter);
        
        clientTextEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(!chatClientText.getText().trim().isEmpty()){
         		
            		sendMessage();
            	
            	}
            }
            
        });
        
        chatClientText.addFocusListener(new FocusAdapter(){
        	public void focusGained(FocusEvent e) {
        		chatClientText.setText("");
            }
        });
        
        new Thread(new Runnable(){
        	public void run(){
        		try{
        			while(true){
        				if(clientMessageIN.hasNext()){
        					String inMessage = clientMessageIN.nextLine();
        					String clientsChatCount = "Онлайн клиентов ";
        					if(inMessage.indexOf(clientsChatCount) == 0){
        						chatClientFramet.setText(chatClientFramet.getText() + inMessage + "\n");	
        					}
        					else{
        						chatClientFramet.setText(chatClientFramet.getText() + inMessage + "\n");
        					}
        				}
        			}
        		}
        		catch(Exception e){
        			
        		}
        	}
        }).start();
        
	}

	public void sendMessage(){
		messageClient = "Сообщение от " + nameClient + "\n" + chatClientText.getText() + "\n";
		clientMessageOUT.println(messageClient);
		clientMessageOUT.flush();
		chatClientText.setText("");
	}
}