package ru.spbstu.telematics.java.monte_carlo;

/**
 * Число Пи методом Монте-Карло
 *
 */
public class MonteCarlo 
{	
	static int nCircle1; //Количество точек, попавших в круг
	MonteCarlo(){
		
		nCircle1 = 0;
	}
    public static void main( String[] args )
    {
    	double pi = 0;    	
    	int maxThread = 1;
    	double rCircle = 1.0; //Радиус круга
    	int n = 90000; //Общее количество точек
    	//Если количество потоков больше количества точек, то уменьшаем количество потоков
    	while(maxThread != 4){
    		if(maxThread > n)
    			maxThread = n;
    	// посчитаем сколько точек "забросит" каждый поток
    		int count = n/maxThread;
    		int additional = n % maxThread; // если не делится на maxThread, то добавим к первому потоку

    		Thread[] threads = new Thread[maxThread];
    		int start = 0;
    		for(int i = 0; i < maxThread; i++)
    		{
    			int cnt = ( i == 0 ? count + additional : count );
    			threads[i] = new MyThreadCircle(rCircle, start, start + cnt - 1);
    			start += cnt;
    			threads[i].start();
    		}
 
    		try{

    			long timeStart = System.currentTimeMillis();

    			for(Thread thread : threads)
    				thread.join();
    			long timeEnd = System.currentTimeMillis();
    			System.out.println("Количество потоков " + maxThread + "; Время:" + Math.abs(timeStart - timeEnd));
          //  System.out.println("Точек в круге " + nCircle1);
    			pi = (double)4*nCircle1/n;
    			System.out.println("Число ПИ вычесленное методом Монте - Карло равно = " + pi);
    			maxThread++;
            	nCircle1 = 0;
    		} 
    		catch(InterruptedException e) {
    			System.out.println("Interrupted");
    		}
    		
    	}
    }
}