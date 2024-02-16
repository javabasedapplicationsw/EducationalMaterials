package com.seoul.springbootdeveloper.service;

import com.seoul.springbootdeveloper.domain.Article;
import com.seoul.springbootdeveloper.dto.AddArticleRequest;
import com.seoul.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor        // final이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
