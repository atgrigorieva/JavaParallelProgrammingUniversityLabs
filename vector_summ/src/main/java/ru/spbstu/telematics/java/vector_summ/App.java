package ru.spbstu.telematics.java.vector_summ;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
//import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//double scalar = 0;
    	ScalarDataRandom data = new ScalarDataRandom();
    	RealVector vector1 = new ArrayRealVector(new double[] {5, 6, 7}, false);
    	RealVector vector2 = new ArrayRealVector(new double[] {4, 2, 6}, false);
    	double scalarResult = data.Scalar(vector1, vector2);
    	System.out.println("Скаллярное произведение 2-х векторов vector1 = " + vector1 + " и vector2 = " + vector2 + " = " + scalarResult);
    	
    	
    	int countData = 10;
    	String randomDataResult = data.RandomData(countData);
    	System.out.println("Сгенирована строка: " + randomDataResult);
    	
    }
 
}
