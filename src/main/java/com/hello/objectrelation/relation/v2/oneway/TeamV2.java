package com.hello.objectrelation.relation.v2.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Entity
@Getter
@NoArgsConstructor
public class TeamV2 {

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<MemberV2> members = new ArrayList<>();

    public TeamV2(String name) {
        this.name = name;
    }
}
