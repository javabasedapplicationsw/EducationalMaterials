package com.seoul.springbootdeveloper.service;

import com.seoul.springbootdeveloper.domain.Article;
import com.seoul.springbootdeveloper.dto.AddArticleRequest;
import com.seoul.springbootdeveloper.dto.UpdateArticleRequest;
import com.seoul.springbootdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor        // final이 붙은 필드의 생성자 추가
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)          // ID를 받아 엔티티 조회함
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));   // 없으면 예외 발생
    }

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional      // 트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}









