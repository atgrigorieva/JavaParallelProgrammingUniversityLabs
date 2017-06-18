package ru.spbstu.telematics.java.museum;

public class Director implements Runnable {

	Controller Security;

	public Director(Controller Security){
		this.Security = Security;	

	}

	public void Close(){

		Security.Close();	

	}

	public void Open(){

		Security.Open();

	}

	public void run() {

		while(true){

			Open();

			try {

				Thread.sleep(10000);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

			Close();

			try {

				Thread.sleep(10000);

			} catch (InterruptedException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		// TODO Auto-generated method stub



	}



}