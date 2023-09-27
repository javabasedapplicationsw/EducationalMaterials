package kr.co.himedia.ploymorphism;

import java.awt.dnd.DnDConstants;
import java.util.ArrayList;

class Animal {
	
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
	
	public void eat() {
		System.out.println("동물이 먹습니다.");
	}
}

class Dog extends Animal {
	
	@Override
	public void move() {
		System.out.println("개가 네발로 걷습니다.");
	}
	
	public void playBall() {
		System.out.println("개가 견주가 던진 공을 물어옵니다.");
	}
	
}

class Tiger extends Animal {
	
	@Override
	public void move() {
		System.out.println("호랑이가 네발로 뜁니다.");
	}
	
	public void hunt() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal {
	
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
	
	public void pickUp() {
		System.out.println("독수리가 물고기를 체갑니다.");
	}
	
}



public class AnimalTest {

	public static void main(String[] args) {
		
		Animal daAnimal = new Dog();   
		Animal taAnimal = new Tiger();  
		Animal eaAnimal = new Eagle();  
		
		AnimalTest test = new AnimalTest();
		test.moveAnimal(daAnimal);
		test.moveAnimal(taAnimal);
		test.moveAnimal(eaAnimal);
		
		System.out.println();
		
		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(daAnimal);
		animalList.add(taAnimal);
		animalList.add(eaAnimal);
		
		//향상된 for문 
		for(Animal animal : animalList)
			animal.move();
		
		System.out.println();
		test.checkDownCast(animalList);
		
	}
	
	public void checkDownCast(ArrayList<Animal> animalList) {
		
		for(int i=0; i<animalList.size(); i++) {
			Animal animal = animalList.get(i);
			
			if(animal instanceof Dog) {
				Dog danimal = (Dog)animal;
				danimal.playBall();
			}
			else if(animal instanceof Tiger) {
				Tiger tanimal = (Tiger)animal;
				tanimal.hunt();
			}
			else if(animal instanceof Eagle) {
				Eagle eanimal = (Eagle)animal;
				eanimal.pickUp();
			}
		}
		
	}

	public void moveAnimal(Animal animal) {
		animal.move();
	}
}























