package com.hohuuan.web.dao;

import com.hohuuan.web.model.Product;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductDAO {
    private final Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    public boolean add(Product product){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(product);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            CriteriaQuery<Product> query = session.getCriteriaBuilder().createQuery(Product.class);
            query.from(Product.class);
            products = session.createQuery(query).getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return products;
    }

    public boolean delete(Long id){
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            if (product != null) {
                session.remove(product);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            if (tx != null) {
                return false;
            }
        }
        return false;
    }
}
