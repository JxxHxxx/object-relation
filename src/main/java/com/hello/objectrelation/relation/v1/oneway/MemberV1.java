package com.hello.objectrelation.relation.v1.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Getter
@NoArgsConstructor
public class MemberV1 {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TeamV1 team;

    public MemberV1(String username) {
        this.username = username;
    }

    public void setTeam(TeamV1 team) {
        this.team = team;
    }
}
