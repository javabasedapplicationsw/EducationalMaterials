package com.seoul.springbootdeveloper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.seoul.springbootdeveloper.Member;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest         // 테스트용 애플리케이션 context 생성
@AutoConfigureMockMvc   // MockMvc 생성 및 자동 구성
class TestControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach     // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach      // 테스트 실행 후 실행하는 메서드
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers : 멤버 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        //given - 멤버를 저장함
        final String url = "/testm";
        Member savedMember = memberRepository.save(new Member(1L, "이순신"));

        //when - 멤버 리스트를 조회하는 API를 호출함
        /*
        perform() : 요청을 전송하는 역할을 하는 메서드
                    결과로 ResultActions 객체임.
                    ResultActions 객체는 반환값을 검증하고 확인하는 andExpect()메서드 제공함
        accept() : 요청을 보낼때 무슨 타입으로 응답을 받을지 결정하는 메서드
        andExpect() : 응답을 검증함
                      OK(200)
         */
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        //then - 응답 코드가 200 ok이고, 반환 받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인함
        /*
            200 ok                  isOk()
            201 Created             isCreated()
            400 Bad Request         isBadRequest()
            jsonPath("$[0].${필드명}"): JSON 응답값의 값을 가져오는 역할을 하는 메서드
                                        0번째 배열에 들어있는 객체의 id, name 값을 가져오고, 저장된 값과 같은지 확인(검증)
         */
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}










