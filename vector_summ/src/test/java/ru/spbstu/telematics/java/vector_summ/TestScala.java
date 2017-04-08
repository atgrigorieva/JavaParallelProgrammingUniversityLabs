package ru.spbstu.telematics.java.vector_summ;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.junit.Assert;
import org.junit.Test;

public class TestScala {

	@Test
	public void ScalarNotNull()
	{
		ScalarDataRandom a = new ScalarDataRandom();
		RealVector vector1 = new ArrayRealVector(new double[] {0, 0, 0}, false);
    	RealVector vector2 = new ArrayRealVector(new double[] {4, 2, 6}, false);
    	Assert.assertNotNull(a.Scalar(vector1, vector2));
	}
	@Test
	public void ScalarNull()
	{
		ScalarDataRandom a = new ScalarDataRandom();
		RealVector vector1 = new ArrayRealVector(new double[] {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, false);
    	RealVector vector2 = new ArrayRealVector(new double[] {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, false);
    	Assert.assertNotNull(a.Scalar(vector1, vector2));    	
	}
}
