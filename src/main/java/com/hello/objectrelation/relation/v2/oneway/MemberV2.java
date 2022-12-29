package com.hello.objectrelation.relation.v2.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Getter
@NoArgsConstructor
public class MemberV2 {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
//    private TeamV2 team;

    public MemberV2(String username) {
        this.username = username;
    }
}
