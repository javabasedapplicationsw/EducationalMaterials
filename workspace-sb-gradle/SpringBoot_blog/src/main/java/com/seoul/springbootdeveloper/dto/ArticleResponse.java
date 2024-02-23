package com.seoul.springbootdeveloper.dto;

import com.seoul.springbootdeveloper.domain.Article;
import lombok.Getter;

@Getter
public class ArticleResponse {

    private String title;
    private String content;

    public ArticleResponse(Article article) {           // 엔터티를 인수로 받는 생성자 추가
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
