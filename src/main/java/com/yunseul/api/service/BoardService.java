package com.yunseul.api.service;

import com.yunseul.api.service.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO createArticle(BoardDTO boardDTO);

    BoardDTO readArticle(String aid);

    List<BoardDTO> readArticles(String uid);

    BoardDTO updateArticle();

    BoardDTO deleteArticle(String aid);

    BoardDTO createComment(BoardDTO boardDTO);

    BoardDTO readComment(String cid);

    List<BoardDTO> readComments(String aid);

    BoardDTO updateComment();

    BoardDTO deleteComment(String cid);
}
