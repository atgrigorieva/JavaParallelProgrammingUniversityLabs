package ru.spbstu.telematics.java.interface_collection;

import java.util.ArrayList;

public class Collection {

	public static void main(String[] args){
		MyListInterface<String> states = new MyListInterface<String>();
		ArrayList<String> statesList = new ArrayList<String>();
		// добавим в список ряд элементов
		states.add("Германия");
		states.add("Франция");
		states.add("Великобритания");
		states.add("Испания");
		
		statesList.add("Германия");
		statesList.add("Франция");
		statesList.add("Великобритания");
		statesList.add("Испания");
		//states.add(1, "Италия"); // добавляем элемент по индексу 1
		
		System.out.println("MyListInterface " + states.get(1));// получаем 2-й объект		
		System.out.println("ArrayListe " + statesList.get(1));// получаем 2-й объект
		///states.set(1, "Дания"); // установка нового значения для 2-го объекта
		
		System.out.printf("MyListInterface В списке %d элементов \n", states.size());
		for(String state : states){		
			System.out.println("MyListInterface " + state);
		}
		
		System.out.printf("ArrayListe В списке %d элементов \n", statesList.size());
		for(String stateList : statesList){		
			System.out.println("ArrayListe " + stateList);
		}
		
		if(states.contains("Германия")){
			System.out.println("MyListInterface Список содержит государство Германия");
		}
		if(statesList.contains("Германия")){
			System.out.println("ArrayListe Список содержит государство Германия");
		}
		// удалим несколько объектов
		states.remove("Германия");
		states.remove("Франция");
		
		Object[] countries = states.toArray();
		for(Object country : countries){		
			System.out.println("MyListInterface " + country);
		}


		statesList.remove("Германия");
		statesList.remove("Франция");
		
		Object[] countriesList = statesList.toArray();
		for(Object countryList : countriesList){		
			System.out.println("ArrayListe " + countryList);
		}
		
	}
}
