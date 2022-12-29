package com.hello.objectrelation.relation.v1.twoway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter
@NoArgsConstructor
public class TeamV1 {

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    List<MemberV1> members = new ArrayList<>();

    public TeamV1(String name) {
        this.name = name;
    }

    public void addMember(MemberV1 member) { // 무한 루프 방지
        this.members.add(member);
        if (member.getTeam() != this) {
            member.setTeam(this);
        }
    }
}
