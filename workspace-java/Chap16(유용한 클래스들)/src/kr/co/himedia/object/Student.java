package kr.co.himedia.object;

public class Student implements Cloneable {

	private int studentId;
	private String studentName;
	
	public Student(int studentId, String studentName) {
		//super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return studentId +", "+ studentName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student stu = (Student)obj;			//다운캐스팅
			if(this.studentId == stu.studentId)
				return true;
			else
				return false;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return studentId;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
	
}










