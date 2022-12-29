package com.hello.objectrelation.relation.v1;

import com.hello.objectrelation.relation.v1.oneway.MemberV1;
import com.hello.objectrelation.relation.v1.oneway.TeamV1;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Controller
public class V1Controller {

//    @PostConstruct
    public void postConstruct(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myFactory");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();


        transaction.begin();
        MemberV1 memberA = new MemberV1("재헌");
        MemberV1 memberB = new MemberV1("윤종");

        TeamV1 team = new TeamV1("7조");
        memberA.setTeam(team);

        em.persist(memberB);
        em.persist(memberA);
        em.persist(team);

        transaction.commit();
    }
}
