package com.yunseul.api.service;

import com.yunseul.api.repository.ArticleRepository;
import com.yunseul.api.repository.CommentRepository;
import com.yunseul.api.service.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public BoardDTO createArticle() {
        return null;
    }

    @Override
    public BoardDTO readArticle(String aid) {
        return null;
    }

    @Override
    public List<BoardDTO> readArticles(String uid) {
        return null;
    }

    @Override
    public BoardDTO updateArticle() {
        return null;
    }

    @Override
    public BoardDTO deleteArticle(String aid) {
        return null;
    }

    @Override
    public BoardDTO createComment(BoardDTO boardDTO) {
        return null;
    }

    @Override
    public BoardDTO readComment(String cid) {
        return null;
    }

    @Override
    public List<BoardDTO> readComments(String aid) {
        return null;
    }

    @Override
    public BoardDTO updateComment() {
        return null;
    }

    @Override
    public BoardDTO deleteComment(String cid) {
        return null;
    }
}
