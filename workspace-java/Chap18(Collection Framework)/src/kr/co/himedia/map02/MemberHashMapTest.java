package kr.co.himedia.map02;


public class MemberHashMapTest {

	public static void main(String[] args) {
		
		MemberHashMap memberHashMap = new MemberHashMap();
		
		Member memberL = new Member(2023, "이순신");
		Member memberW = new Member(2024, "원균");
		Member memberR = new Member(2025, "나대용");
		Member memberS = new Member(2026, "류성룡");
		Member memberS2 = new Member(2026, "류성룡2");
		
		memberHashMap.addMember(memberL);
		memberHashMap.addMember(memberW);
		memberHashMap.addMember(memberR);
		memberHashMap.addMember(memberS);
		memberHashMap.addMember(memberS2);
		
		memberHashMap.showAllMember();
		
		memberHashMap.removeMember(2025);
		memberHashMap.showAllMember();
		
		
	}			
	
}
