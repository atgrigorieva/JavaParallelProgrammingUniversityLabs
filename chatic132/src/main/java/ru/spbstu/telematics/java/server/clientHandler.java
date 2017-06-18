package ru.spbstu.telematics.java.server;

import ru.spbstu.telematics.java.server.serverChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class clientHandler implements Runnable{
	private serverChat server;
	private Socket socketClient = null;//сокет клиента
	private int clientsCount; //клиентов в чате
	private Scanner inMessage; // входящее собщение
	private PrintWriter outMessage; // исходящее сообщение
    private static final String HOST = "localhost";
    private static final int PORT = 6663;
	public clientHandler(int clientnew, Socket clientSocket1, serverChat server){
		try{
			//clientCount++;
			this.clientsCount = clientnew;
			//clientsCount++;
			this.server = server;
			this.socketClient = clientSocket1;
			this.outMessage = new PrintWriter(clientSocket1.getOutputStream());
            this.inMessage = new Scanner(clientSocket1.getInputStream());
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void run() {
		try{
			while(true){
				clientsCount++;
				server.clientMessage("В чате новый пользователь("+new Date().toString()+")");
				server.clientMessage("Клиентов в чате = " + clientsCount);
                break;
			}
			while (true) {
                // Если от клиента пришло сообщение
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
										// если клиент отправляет данное сообщение, то цикл прерывается и 
										// клиент выходит из чата
                    if (clientMessage.equalsIgnoreCase("exit")) {
                        break;
                    }
										// выводим в консоль сообщение (для теста)
                    System.out.println(clientMessage);
										// отправляем данное сообщение всем клиентам
                    server.clientMessage(clientMessage);
                }
								// останавливаем выполнение потока на 100 мс
                Thread.sleep(100);
            }
		}
		catch(InterruptedException e){
			e.printStackTrace();			
		}
		finally{
			this.close();
		}

	}
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // клиент выходит из чата
    public void close() {
        // удаляем клиента из списка
        server.removeClient(this);
       // clientsCount;
        server.clientMessage("Клиентов онлайн: " + clientsCount);

    }
}
