package com.hillstate.penthouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class PenthouseApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("인생이란 무엇인가?");
		q1.setContent("인생에 대해 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("스프링 부트란 무엇인가?");
		q2.setContent("id는 자동으로 생성되는가?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

}















