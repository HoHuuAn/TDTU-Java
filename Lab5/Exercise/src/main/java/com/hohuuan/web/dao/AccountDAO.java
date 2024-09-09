package com.hohuuan.web.dao;

import com.hohuuan.web.model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AccountDAO {

    private final Session session;

    public AccountDAO(Session session){this.session = session;}

    public boolean add(Account account){
        try {
            Transaction tx = session.beginTransaction();
            session.persist(account);
            tx.commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Account get(String email, String password){
        Transaction tx = session.beginTransaction();
        Query<Account> q = session.createQuery("SELECT a from Account a where a.email =:em and a.password =: pw", Account.class);
        q.setParameter("em", email);
        q.setParameter("pw", password);
        tx.commit();
        return q.getSingleResultOrNull();
    }
}
