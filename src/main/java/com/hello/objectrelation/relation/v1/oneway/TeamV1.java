package com.hello.objectrelation.relation.v1.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Getter
@NoArgsConstructor
public class TeamV1 {

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public TeamV1(String name) {
        this.name = name;
    }
}
