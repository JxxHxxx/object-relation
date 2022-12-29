package com.hello.objectrelation.relation.v2;

import com.hello.objectrelation.relation.v2.oneway.MemberV2;
import com.hello.objectrelation.relation.v2.oneway.TeamV2;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Controller
public class V2Controller {

//    @PostConstruct
    public void postConstruct(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myFactory");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        MemberV2 memberA = new MemberV2("재헌");
        MemberV2 memberB = new MemberV2("윤종");
        TeamV2 team = new TeamV2("7조");

        team.getMembers().add(memberA);
        team.getMembers().add(memberB);
        em.persist(team);
        em.persist(memberA);
        em.persist(memberB);

        transaction.commit();
    }
}
