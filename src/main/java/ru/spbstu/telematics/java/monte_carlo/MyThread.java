package ru.spbstu.telematics.java.monte_carlo;

class MyThreadCircle extends Thread {
	static double x, y;
	private int startN, endN;
	int nCircle = 0;
	private double rCircle;
	public MyThreadCircle(double rCircle, int startN, int endN) {
		 this.startN = startN;
	     this.endN = endN;
	     this.rCircle = rCircle;
	    
	}
	
	public int MonteCarloCircle(int nCircle){
		int c = 0;
		x = (Math.random()*2) - 1;
		y = (Math.random()*2) - 1;
		if((Math.pow(x, 2) + Math.pow(y, 2)) <= rCircle){			
			c++;
		}		
		return c;
	
	}
	public void run() {	
		for(int i = startN; i < endN; i++){
			nCircle += MonteCarloCircle(nCircle);
		}
		MonteCarlo.nCircle1 += nCircle; 	
	
	}
}