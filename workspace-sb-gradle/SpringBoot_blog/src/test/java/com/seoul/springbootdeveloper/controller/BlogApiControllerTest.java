package com.seoul.springbootdeveloper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seoul.springbootdeveloper.domain.Article;
import com.seoul.springbootdeveloper.dto.AddArticleRequest;
import com.seoul.springbootdeveloper.dto.UpdateArticleRequest;
import com.seoul.springbootdeveloper.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest         // 테스트용 애플리케이션 context 생성
@AutoConfigureMockMvc   // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;        // 직렬화, 역직렬화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach             // 테스트 실행 전 실행하는 메서드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        blogRepository.deleteAll();
    }

    @DisplayName("addArticle : 블로그 글 추가에 성공했습니다.")
    @Test
    public void addArticle() throws Exception {
        // given. 블로그 글 추가에 필요한 요청객체 생성
        final String url = "/api/articles";
        final String title = "안녕하세요.";
        final String content = "이제 주말이 다가오네요";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        // 객체를 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        // when
        // 설정한 내용을 바탕으로 블로그 글 추가 API에 요청 전송
          ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)          // 요청 타입은 JSON임
                .content(requestBody));                                 // 미리 만들어둔 객체를 요청 본문으로 함께 보냄

        // then
        result.andExpect(status().isCreated());                     // 응답코드가 201 Created인지 확인

       List<Article> articles = blogRepository.findAll();           // 전체 조회

       assertThat(articles.size()).isEqualTo(1);            // 크기가 1인지 검증(확인)
       assertThat(articles.get(0).getTitle()).isEqualTo(title);     // 실제로 저장된 데이터와 요청 값 비교
        assertThat(articles.get(0).getContent()).isEqualTo(content);

    }

    @DisplayName("findAllArticles: 블로그 글 목록 조회에 성공한다.")
    @Test
    public void findAllArticles() throws Exception {
        // given. 테스트에 사용할 블로그 글의 제목과 내용 정의
        final String url = "/api/articles";
        final String title = "안녕하세요.";
        final String content = "이제 주말이 다가오네요";

        blogRepository.save(Article.builder()       // 테스트를 위해 블로그 글을 데이터베이스에 저장
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url)     // MockMvc를 사용하여 지정된 url에 GET 요청 보냄
                .accept(MediaType.APPLICATION_JSON_VALUE));             // 그 결과를 ResultActions 객체로 받음

        // Then      반환된 결과 검증
        resultActions
                .andExpect(status().isOk())         // HTTP 상태 코드가 200 ok
                .andExpect(jsonPath("$[0].content").value(content))     // JSON 응답의 첫번째 항목이 주어진 제목과
                .andExpect(jsonPath("$[0].title").value(title));        // 내용을 가지고 있는지 확인함
    }

    @DisplayName("findArticle : 블로그 글 조회에 성공한다.")
    @Test
    public void findArticle() throws Exception {
        // given
        final String url = "/api/articles/{id}";
        final String title = "안녕하세요.";
        final String content = "이제 주말이 다가오네요";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url, savedArticle.getId()));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.title").value(title));
    }

    @DisplayName("deleteArticle: 블로그 글 삭제에 성공한다.")
    @Test
    public void deleteArticle() throws Exception {
        // given - 블로그 글을 저장함
        final String url = "/api/articles/{id}";
        final String title = "안녕하세요.";
        final String content = "이제 주말이 다가오네요";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when - 저장한 블로그 글의 id값으로 삭제 API 호출함
        mockMvc.perform(delete(url, savedArticle.getId() ))
                .andExpect(status().isOk());

        // then - 응답 코드가 200 ok이고, 블로그 글 리스트를 전체 조회한 배열 크기가 0인지 확인함
        List<Article> articles = blogRepository.findAll();

        assertThat(articles).isEmpty();
    }

    @DisplayName("updateArticle: 블로그 글 수정에 성공한다.")
    @Test
    public void updateArticle() throws Exception {
        // given - 블로그 글을 저장하고, 블로그 글 수정에 필요한 요청 객체를 생성함
        final String url = "/api/articles/{id}";
        final String title = "안녕하세요.";
        final String content = "이제 주말이 다가오네요";

        Article savedArticle = blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        final String newTitle = "밤새 안녕하세요.";
        final String newContent = "이제 봄이 다가오네요";

        UpdateArticleRequest request = new UpdateArticleRequest(newTitle, newContent);

        // when - UPDATE API로 수정 요청 보냄. 이때 요청 타입은 JSON이며, given절에서 미리 만들어둔 객체를 요청 본문으로 함께 보냄
        ResultActions result = mockMvc.perform(put(url, savedArticle.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request)));

        // then - 응답 코드가 200 OK인지 확인함. 블로그 id로 조회한 후에 값이 수정되었는지 확인함
        result.andExpect(status().isOk());

        Article article = blogRepository.findById(savedArticle.getId()).get();
        assertThat(article.getTitle()).isEqualTo(newTitle);
        assertThat(article.getContent()).isEqualTo(newContent);
    }
}
















