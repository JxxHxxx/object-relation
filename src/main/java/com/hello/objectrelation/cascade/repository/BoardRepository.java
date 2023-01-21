package com.hello.objectrelation.cascade.repository;


import com.hello.objectrelation.cascade.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board as b")
    Board findBoard(Long id);

}
