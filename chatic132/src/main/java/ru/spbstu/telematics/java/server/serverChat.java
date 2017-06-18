package ru.spbstu.telematics.java.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverChat {
	private int clientCount; //клиентов в чате
	private final int portInclude = 6663;//порт прослушки
	private ArrayList<clientHandler> clients = new ArrayList<clientHandler>(); //список клиентов, подключенных к серверу
	public serverChat(){
		
		Socket clientSocket = null;
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(portInclude); //Создаем серверный сокет на порту 6663
			System.out.println("Сервер запущен");
			//Если серверный сокет успешно создан на указанном порту, то ждем подключений от клиента
			while(true){
				clientSocket = serverSocket.accept();// Ожидание подключения клиента
				clientCount = clients.size();
				clientHandler client = new clientHandler(clientCount, clientSocket, this);
				clients.add(client);
				new Thread(client).start();//подключение для каждого клиента обрабатываем в новом потоке
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				clientSocket.close();//Закрываем подключение
				System.out.print("Сервер остановлен");
				serverSocket.close();
				
			}
			catch(IOException e){
				 e.printStackTrace();
			}
		}
	}
	//Отправка сообщений всем клиентам
	public void clientMessage(String msg){
		 for (clientHandler o : clients) {
	            o.sendMsg(msg);
	        }
	}
	public void removeClient(clientHandler client){
		clients.remove(client);
	}
}
