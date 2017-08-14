package com.yunseul.api.service;

import com.yunseul.api.service.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO createArticle();

    BoardDTO readArticle();

    List<BoardDTO> readArticles();

    BoardDTO updateArticle();

    BoardDTO deleteArticle();

    BoardDTO createComment();

    BoardDTO readComment();

    List<BoardDTO> readComments();

    BoardDTO updateComment();

    BoardDTO deleteComment();
}
