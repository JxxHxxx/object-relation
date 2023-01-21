package com.hello.objectrelation.cascade.controller;

import com.hello.objectrelation.cascade.dto.CommentOnlyDto;
import com.hello.objectrelation.cascade.entity.Board;
import com.hello.objectrelation.cascade.entity.Comment;
import com.hello.objectrelation.cascade.repository.BoardRepository;
import com.hello.objectrelation.cascade.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JpqlController {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;


    @GetMapping("/jpql/board/{boardId}/comment")
    public List<CommentOnlyDto> findOnlyComments(@PathVariable Long boardId) {
        List<CommentOnlyDto> comments = commentRepository.findAllByBoard(boardId);
        for (CommentOnlyDto comment : comments) {
            log.info("comment {}", comment.getText());
        }
        return comments;
    }

    @GetMapping("/jpa/comment")
    public List<Comment> findCommentsFull() {
        return commentRepository.findAll();
    }

    @GetMapping("/jpql/comment")
    public List<CommentOnlyDto> findOnlyTextCommentsFull() {
        return commentRepository.findAllText();
    }

    @GetMapping("/npo/board/{id}")
    public Board opo(@PathVariable Long id) {
        return boardRepository.findById(id).get();
    }

    @GetMapping("/npo2/board/{id}")
    public Board opo2(@PathVariable Long id) {
        return boardRepository.findBoard(id);
    }
}
