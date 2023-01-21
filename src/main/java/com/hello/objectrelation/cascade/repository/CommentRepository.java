package com.hello.objectrelation.cascade.repository;

import com.hello.objectrelation.cascade.dto.CommentOnlyDto;
import com.hello.objectrelation.cascade.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select co.text as text from Comment as co")
    List<CommentOnlyDto> findAllText();

    @Query(value = "select co.text from Comment as co",nativeQuery = true)
    List<CommentOnlyDto> findAllCommentV2();

    @Query(value = "SELECT co.text from Comment as co " + "WHERE BOARD_ID = ?1", nativeQuery = true)
    List<CommentOnlyDto> findAllByBoard(Long boardId);


}
