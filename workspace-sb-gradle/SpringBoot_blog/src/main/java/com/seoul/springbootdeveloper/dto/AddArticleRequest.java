package com.seoul.springbootdeveloper.dto;

import com.seoul.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor              // 기본 생성자 추가
@AllArgsConstructor             // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() {         // 빌더 패턴을 사용한 생성자로 객체 생성
        return Article.builder()        // DTO를 엔터티로 만들어줌
                .title(title)           // ==> 블로그 글 추가할때 저장할 엔터티로 변환됨
                .content(content)
                .build();
    }

}


















