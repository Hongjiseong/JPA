package com.example.jpa.runner;

import com.example.jpa.entity.Account;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("hong");
        account.setPassword("1234hibernate");

        // 테이블 생성해서 처리하는 두가지 방법
        // 1. persist(account);
        // 2. save(account);
    }

    public void persist(Account account){
        entityManager.persist(account);
    }

    public void save(Account account){
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }
}
