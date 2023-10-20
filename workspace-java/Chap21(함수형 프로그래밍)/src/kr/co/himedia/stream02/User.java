package kr.co.himedia.stream02;

public class User {

	private int id;
	private String name;
	private String emailAddress;
	private boolean isVerified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", isVerified=" + isVerified
				+ "]";
	}
	
	
}
