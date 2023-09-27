package kr.co.himedia.abstractclass;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer computer = new DeskTop();
		computer.display();
		computer.turnOff();
		
		System.out.println();
		
		NoteBook myNote = new MyNoteBook();
		myNote.typing();
		myNote.display();
		
	}
}
