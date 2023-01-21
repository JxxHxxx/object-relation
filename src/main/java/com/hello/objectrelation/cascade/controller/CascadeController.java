package com.hello.objectrelation.cascade.controller;

import com.hello.objectrelation.cascade.entity.Board;
import com.hello.objectrelation.cascade.entity.Comment;
import com.hello.objectrelation.cascade.repository.BoardRepository;
import com.hello.objectrelation.cascade.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class CascadeController {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @PostConstruct
    public void init() {
    }

    @PostMapping("/cascade/board")
    public String createBoard(@RequestBody Board board) {
        boardRepository.save(board);
        return "게시글 저장 완료";
    }

    @PostMapping("/cascade/board/{boardId}/comment")
    public String createComment(@PathVariable Long boardId, @RequestBody Comment comment) {
        Board board = boardRepository.findById(boardId).get();
        Comment saveComment = new Comment(comment,board);
        commentRepository.save(saveComment);
        return "댓글 저장 완료";
    }

    @DeleteMapping("/cascade/board/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {
        boardRepository.deleteById(boardId);
        return "게시글 삭제 완료";
    }

}
