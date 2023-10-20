package kr.co.himedia.stream02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
		Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
		List<Integer> filteredNumber =  filteredNumberStream.collect(Collectors.toList());
		System.out.println(filteredNumber);
		
		List<Integer> filteredNumber2 = Stream.of(3, -5, 7, 10, -3).filter(x -> x > 0).collect(Collectors.toList());
		System.out.println(filteredNumber2);
		
		User user1 = new User();
		user1.setId(101);
		user1.setName("이순신");
		user1.setVerified(true);
		user1.setEmailAddress("Admiral@gmail.com");
		
		User user2 = new User();
		user2.setId(102);
		user2.setName("신사임당");
		user2.setVerified(false);
		user2.setEmailAddress("Shin@gmail.com");
		
		User user3 = new User();
		user3.setId(103);
		user3.setName("류성룡");
		user3.setVerified(true);
		user3.setEmailAddress("Ryu@gmail.com");		
		
		List<User> users = Arrays.asList(user1, user2, user3);
		List<User> verifiedUsers = users.stream().filter(user -> user.isVerified()).collect(Collectors.toList());
		System.out.println(verifiedUsers);
		
		List<User> unVerifiedUsers = users.stream().filter(user -> !user.isVerified()).collect(Collectors.toList());
		System.out.println(unVerifiedUsers);
		
		
	}
}

















