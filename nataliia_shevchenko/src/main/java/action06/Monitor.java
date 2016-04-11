package action06;
/*Задача:
Написать класс Monitor(nameFile1,nameFile2), в котором два потока.
1. Поток 1(ThreadCreator), считывает строку с консоли записывает в nameFile1, 
 будит поток 2.(objSynchro.notify())
2. Поток 2(ThreadWriter), копирует nameFile1 в nameFile2 и засыпает. 
 (objSynchro.wait()) 
Примечание: 
1. если с консоли введено слово "exit" или "quit", то поток №1 останавливать.
2. продумать остановку и второго потока.*/

import java.io.File;

public class Monitor {
	
	private File nameFile1;
	private File nameFile2;
	private Thread t1;
	private Thread t2;
	
	public Monitor(File nameFile1, File nameFile2) {
		super();
		this.nameFile1 = nameFile1;
		this.nameFile2 = nameFile2;
		t1 = new ThreadCreator();
		t2 = new ThreadWriter();
	}
	
	
}
