package ru.spbstu.telematics.java.client;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inChat extends JFrame {
	
	private JLabel nameLabel;
	private JButton enterButton;
	private JTextField nameText;
	private JPanel content;
	public inChat(){
		
		super("Вход в чат");
		content = new JPanel();
	    content.setLayout(null);
	    setSize(320,135);
	    setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(content);
        
		nameLabel = new JLabel("Логин");
		content.add(nameLabel);
		nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nameLabel.setBounds(5,5,95,21);
		
		nameText = new JTextField("Введите ваше имя");
		nameText.setFont(new Font("Arial", Font.PLAIN, 14)); //Семейство шрифта, размер шрифта
		nameText.setHorizontalAlignment(JTextField.LEFT); //Выравнивание текста	
		nameText.setBounds(100,5,200,21);
		content.add(nameText);
		
		enterButton = new JButton("Войти");
		enterButton.setBounds(115,60,75,21);
		content.add(enterButton);
	
		enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String textName;
                textName = nameText.getText();
                if(!nameText.getText().trim().isEmpty()){
                	
                	Chat_Interface interfaceChat = new Chat_Interface(textName);
                	interfaceChat.setVisible(true);
                	dispose();
                }
                else{
                	nameText.grabFocus();
                	
                }
            }

       });
        nameText.addFocusListener(new FocusAdapter(){
        	public void focusGained(FocusEvent e) {
        		nameText.setText("");
            }
        });
	}
}
