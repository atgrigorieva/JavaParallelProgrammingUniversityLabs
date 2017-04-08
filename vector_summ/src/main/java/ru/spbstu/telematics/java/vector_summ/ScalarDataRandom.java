package ru.spbstu.telematics.java.vector_summ;

//import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.RandomDataGenerator;


public class ScalarDataRandom {

	
	public double Scalar(RealVector vector1, RealVector vector2)
	{
    	double scalar = vector1.dotProduct(vector2);
    	return scalar;
	}
	
	public String RandomData(int countData)
	{
		RandomDataGenerator abs = new RandomDataGenerator();
		String randomString = abs.nextHexString(countData);
		return randomString;
	}
}
