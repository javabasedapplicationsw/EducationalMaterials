package kr.co.himedia.userdefinetype02;

//=> 이순신, 30, 010-1234-5678, admiral@gmail.com, 서울, 80.6kg 
public class MemberTest {

	public static void main(String[] args) {
		//한 명의 헬스클럽 회원 데이터를 저장하고 출력하시오.
		
		Member member = new Member();
		member.name = "이순신";
		member.age = 30;
		member.tel = "010-1234-5678";
		member.email = "admiral@gmail.com";
		member.addr = "서울";
		member.weight = 80.6f;
		
		System.out.println(member.name +"\t"+ member.age +"\t"+ member.tel +"\t"+ member.email 
							+"\t"+ member.addr +"\t"+ member.weight);
	}
}
