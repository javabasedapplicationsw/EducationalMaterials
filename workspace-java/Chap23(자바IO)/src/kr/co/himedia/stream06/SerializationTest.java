package kr.co.himedia.stream06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	private String name;
	/* transient */ private String job;
	
	public Person() {}

	public Person(String name, String job) {
		//super();
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return name +", "+ job;
	}
	
}

public class SerializationTest {
	public static void main(String[] args) {
		Person personL = new Person("이순신", "대표이사");
		Person personK = new Person("김유신", "상무이사");
		
		try(FileOutputStream fos = new FileOutputStream("serial.out");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(personL);
			oos.writeObject(personK);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		try(FileInputStream fis = new FileInputStream("serial.out");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Person p1 = (Person) ois.readObject();
			Person p2 =  (Person) ois.readObject();
			
			System.out.println(p1);
			System.out.println(p2);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}








