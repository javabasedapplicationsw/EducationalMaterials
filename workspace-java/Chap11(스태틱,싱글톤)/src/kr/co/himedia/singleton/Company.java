package kr.co.himedia.singleton;

public class Company {
	
	private Company() {}
	
	private static Company instance = new Company();
	
	public static Company getInstance() {
		
		if(instance == null)
			instance = new Company();
		return instance;
		
	}

}
