package com.yunseul.api.controller;

import com.yunseul.api.controller.model.ApiResponse;
import com.yunseul.api.service.BoardService;
import com.yunseul.api.service.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
public class BoardControllerV1 {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ApiResponse<BoardDTO> createArticle(@RequestBody BoardDTO boardDTO) {
        return new ApiResponse<>(boardService.createArticle(boardDTO));
    }

    @RequestMapping(value = "/article/{aid}", method = RequestMethod.GET)
    public ApiResponse<BoardDTO> readArticle(@PathVariable String aid) {
        return new ApiResponse<>(boardService.readArticle(aid));
    }

    @RequestMapping(value = "/articles/{uid}", method = RequestMethod.GET)
    public ApiResponse<List<BoardDTO>> readArticles(@PathVariable String uid) {
        return new ApiResponse<>(boardService.readArticles(uid));
    }

    @RequestMapping(value = "/articles/{aid}", method = RequestMethod.POST)
    public ApiResponse<BoardDTO> deleteArticle(@PathVariable String aid) {
        return new ApiResponse<>(boardService.deleteArticle(aid));
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ApiResponse<BoardDTO> createComment(@RequestBody BoardDTO boardDTO) {
        return new ApiResponse<>(boardService.createComment(boardDTO));
    }

    @RequestMapping(value = "/comment/{cid}", method = RequestMethod.GET)
    public ApiResponse<BoardDTO> readComment(@PathVariable String cid) {
        return new ApiResponse<>(boardService.readComment(cid));
    }

    @RequestMapping(value = "/comments/{aid}", method = RequestMethod.GET)
    public ApiResponse<List<BoardDTO>> readComments(@PathVariable String aid) {
        return new ApiResponse<>(boardService.readComments(aid));
    }

    @RequestMapping(value = "/comments/{cid}", method = RequestMethod.POST)
    public ApiResponse<BoardDTO> deleteComment(@PathVariable String cid) {
        return new ApiResponse<>(boardService.deleteComment(cid));
    }
}
