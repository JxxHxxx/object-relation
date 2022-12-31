package com.hello.objectrelation.relation.v3.oneway;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Entity
@Getter
@NoArgsConstructor
public class CarV3 {

    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    양방향일 때,
//    @OneToOne(mappedBy = "car")
//    private MemberV3 member;

    public CarV3(String name) {
        this.name = name;
    }
}
