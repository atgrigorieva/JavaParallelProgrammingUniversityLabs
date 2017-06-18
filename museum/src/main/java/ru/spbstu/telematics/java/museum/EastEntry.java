package ru.spbstu.telematics.java.museum;

import java.util.Random;

public class EastEntry implements Runnable {
	Controller Security;

	public EastEntry(Controller Security){
		this.Security = Security;
	}

	void Exit(){
		Security.Exit();
	}

	public void run() {
		while(true){
			Exit();
			try {
				Thread.sleep(new Random().nextInt(3000));
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}




	}
}
