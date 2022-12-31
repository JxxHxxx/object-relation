package com.hello.objectrelation.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Slf4j
@RestController
public class ProxyController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myFactory");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    @PostConstruct
    void init() {
        transaction.begin();

        Member memberA = new Member("jamong");
        Member memberB = new Member("podo");

        Team team = new Team("hanghae");
        memberA.setTeam(team);
        em.persist(memberA);
        em.persist(memberB);
        em.persist(team);

        transaction.commit();
        em.clear();
    }
    @GetMapping("/proxy")
    public void getUserName() {
        Member proxyMember = em.getReference(Member.class, 1l);
        log.info("proxy {}", emf.getPersistenceUnitUtil().isLoaded(proxyMember));
        System.out.println(proxyMember.getUsername());
    }

    @GetMapping("/proxy-lazy")
    public void getTeamName() {
        Member proxyMember = em.getReference(Member.class, 1l);
        log.info("proxy {}", emf.getPersistenceUnitUtil().isLoaded(proxyMember));
        System.out.println(proxyMember.getTeam().getName());
    }
    @GetMapping("/proxy2")
    public void proxyVsEntity2() {
        Member proxyMember = em.getReference(Member.class, 1l);
        Member entityMember = em.find(Member.class, 1l);

        System.out.println("proxyMember class = " + proxyMember.getClass());
        System.out.println("entityMember class = " + entityMember.getClass());

        em.clear();
    }
    @GetMapping("/proxy3")
    public void proxyVsEntity3() {
        Member proxyMember = em.getReference(Member.class, 1l);
        Member entityMember = em.find(Member.class, 2l);

        System.out.println("proxyMember class = " + proxyMember.getClass());
        System.out.println("entityMember class = " + entityMember.getClass());

        em.clear();
    }

    @GetMapping("/proxy4")
    public void proxyVsEntity4() {
        Member proxyMember = em.getReference(Member.class, 1l);
        System.out.println("entityMember class = " + proxyMember.getId());
        System.out.println("프록시 객체 초기화 여부 = " + emf.getPersistenceUnitUtil().isLoaded(proxyMember));
        em.clear();
    }


}
