package com.hello.objectrelation.relation.v3.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Getter
@NoArgsConstructor
public class MemberV3 {

    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne
    @JoinColumn(name = "CAR_ID")
    private CarV3 car;

    public MemberV3(String username) {
        this.username = username;
    }
}
