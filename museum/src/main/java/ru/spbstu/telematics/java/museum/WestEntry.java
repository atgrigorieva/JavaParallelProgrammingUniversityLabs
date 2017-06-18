package ru.spbstu.telematics.java.museum;

import java.util.Random;

public class WestEntry implements Runnable {

	Controller Security;

	public WestEntry(Controller Security){
		this.Security = Security;	

	}

	void Enter(){
		Security.Enter();

	}

	public void run() {
		while(true){
			Enter();
			try {
				Thread.sleep(new Random().nextInt(3000));

			}
			catch (InterruptedException e) {
				e.printStackTrace();

			}

		}



	}
}
