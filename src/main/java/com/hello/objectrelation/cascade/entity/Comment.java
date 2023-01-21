package com.hello.objectrelation.cascade.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped{

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOARD_ID")
    @JsonProperty(access = WRITE_ONLY)
    private Board board;

    private String text;

    public Comment(Comment comment, Board board) {
        this.text = comment.getText();
        this.board = board;
    }
}
