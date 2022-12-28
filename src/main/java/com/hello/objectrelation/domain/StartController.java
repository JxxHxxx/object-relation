package com.hello.objectrelation.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
@Controller
public class StartController {

    @PostConstruct
    void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myFactory");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        log.info("저장을 시작합니다.");

        transaction.begin();
        Team team = new Team("team1", "팀1");
        em.persist(team);

        Member member1 = new Member("member1", "회원1");
        member1.setTeam(team);
        em.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team);
        em.persist(member2);

        transaction.commit();
        log.info("저장 커밋을 완료합니다.");

        log.info("수정을 시작합니다.");
        transaction.begin();

        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);

        transaction.commit();
        log.info("수정 커밋을 완료합니다.");

        log.info("연관 관계를 삭제합니다.");
        transaction.begin();

        member1.setTeam(null);

        transaction.commit();
        log.info("연관 관계 삭제 커밋을 완료합니다.");
    }
}
