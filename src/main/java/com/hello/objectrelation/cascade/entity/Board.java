package com.hello.objectrelation.cascade.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
