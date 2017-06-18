package ru.spbstu.telematics.java.museum;

public class MainMuseum {

	public static void main(String[] args) {
		Controller Security = new Controller();
		Director Dir_People = new Director(Security);
		EastEntry east_entry = new EastEntry(Security);
		WestEntry west_entry = new WestEntry(Security);
    	new Thread(Security).start();
    	new Thread(Dir_People).start();
    	new Thread(east_entry).start();
    	new Thread(west_entry).start();

	}

}
