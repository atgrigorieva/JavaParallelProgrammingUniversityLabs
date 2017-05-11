package ru.spbstu.telematics.java.interface_sollection;

import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.telematics.java.interface_collection.MyListInterface;

public class CollectionTest {

	@Test
	public void CollectionGet(){
		MyListInterface<String> states = new MyListInterface<String>();
		states.add("Германия");
		states.add("Франция");
		states.add("Великобритания");
		states.add("Испания");
		Assert.assertEquals(states.get(1), "Франция");
	}
}
