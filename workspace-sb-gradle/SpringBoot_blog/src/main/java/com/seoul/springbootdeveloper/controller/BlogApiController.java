package com.seoul.springbootdeveloper.controller;

import com.seoul.springbootdeveloper.service.BlogService;
import com.seoul.springbootdeveloper.domain.Article;
import com.seoul.springbootdeveloper.dto.AddArticleRequest;
import com.seoul.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
