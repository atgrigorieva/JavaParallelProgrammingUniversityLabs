package ru.spbstu.telematics.java.museum;

public class Controller implements Runnable {

	Integer CountVisitors = 0;
	boolean Is_open = false;

	public void Enter(){

		if (Is_open){
			synchronized(CountVisitors){
				CountVisitors++;
			}
			System.out.println("����� ����������");

		}

	} 
	
	public void Exit(){

		if (CountVisitors != 0 && Is_open == true){

			synchronized(CountVisitors){

				CountVisitors--;

		}

			System.out.println("������� ����� �� �����");

		}

	}

	public void Open(){
		Is_open = true;
		System.out.println("���� ������");

	}

	public void Close(){

		Is_open = false;
		CountVisitors = 0;
		System.out.println("���� ������");

	}

	public void run() {

		while(true);

		// TODO Auto-generated method stub



	}



}