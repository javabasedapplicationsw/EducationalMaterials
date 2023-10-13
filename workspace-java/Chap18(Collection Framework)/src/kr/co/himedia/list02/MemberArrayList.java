package kr.co.himedia.list02;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {
	
	//ArrayList 선언
	private ArrayList<Member> arrayList;
	
	//생성자 - 멤버로 선언한 ArrayList 생성
	public MemberArrayList() {
		arrayList = new ArrayList<>();		
	}
	
	//ArrayList에 멤버 추가
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	//멤버 아이디를 매개변수로 삭제 여부를 반환 
	public boolean removeMember(int memberId) {
		
//		for(int i=0; i<arrayList.size(); i++) {	// 해당 memberId를 가진 멤버를 ArrayList에서 찾음
//			Member member = arrayList.get(i);
//			int tempId = member.getMemberId();
//			if(tempId == memberId) {			// ArrayList에 있는 멤버아이디가 매개변수의 멤버아이디와 일치하면
//				arrayList.remove(i);			// 해당 멤버 삭제
//				return true;
//			}
//		}
		
		Iterator<Member> ir = arrayList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId +" 가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList)
			System.out.println(member);
		System.out.println();
	}

}






















