    package com.hohuuan.web.db;

import com.hohuuan.web.model.Account;
import com.hohuuan.web.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory factory;
    public static Session getSession(){
        if(factory == null){
            factory = new Configuration().configure()
                    .addAnnotatedClass(Account.class)
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        }
        return factory.openSession();
    }
}
