package com.seoul.springbootdeveloper.controller;

import com.seoul.springbootdeveloper.dto.ArticleResponse;
import com.seoul.springbootdeveloper.dto.UpdateArticleRequest;
import com.seoul.springbootdeveloper.service.BlogService;
import com.seoul.springbootdeveloper.domain.Article;
import com.seoul.springbootdeveloper.dto.AddArticleRequest;
import com.seoul.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController         // HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    // HTTP 메서드가 POST일때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")            //  @RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)        // 요청한 자원이 성공적으로 생성되었으며 저장된 글을 응답 객체에 담아 전송
                            .body(savedArticle);
    }

    // /api/articles GET 요청이 오면 글 전체 조회
    // 응답용 객체인 ArticleResponse로 파싱해 body에 담아 클라이언트에게 전송함
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                                .stream()
                               // .map(article -> new ArticleResponse(article))// 일반 람다 표현식
                                .map(ArticleResponse::new) // 메서드 레퍼런스 (람다 표현식 간결하게 표현, 해당 메서드를 호출하는 람다 표현식의 축약된 형태임)
                                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")           // URL에서 {id}에 해당하는 값이 id로 들어옴
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);     // O번 블로그 글을 찾음

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));    // 글을 찾으면 O번 글의 정보를 body에 담아 웹 브라우저로 전송함
    }

    @DeleteMapping("/api/articles/{id}")        // URL에서 {id}에 해당하는 값이 아래 파라미터 id로 들어옴
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")   // Request Body 정보가 request로 넘어옴
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updtedArticle = blogService.update(id, request);

        return ResponseEntity.ok()
                .body(updtedArticle);       // 응답 값은 body에 담아 전송함
    }
}




















