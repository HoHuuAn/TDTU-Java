package com.hohuuan;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO {

    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Phone.class)
            .addAnnotatedClass(Manufacture.class)
            .buildSessionFactory();
    public boolean add(Phone phone) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            session.persist(phone);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Phone get(String id) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            Phone phone = session.get(Phone.class, id);

            transaction.commit();
            session.close();
            return phone;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Phone> getAll() {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            List<Phone> list = session.createQuery("FROM Phone", Phone.class).list();

            transaction.commit();
            session.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean remove(String id) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            if (phone != null) {
                session.remove(phone);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(Phone phone) {
        Session session = factory.getCurrentSession();
        Transaction transaction;
        try {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<Phone> criteriaDelete = criteriaBuilder.createCriteriaDelete(Phone.class);
            Root<Phone> root = criteriaDelete.from(Phone.class);


            List<Predicate> predicates = new ArrayList<>();
            for (Field field : phone.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(phone);
                if (value != null) {
                    predicates.add(criteriaBuilder.equal(root.get(field.getName()), value));
                }
            }

            criteriaDelete.where(predicates.toArray(new Predicate[0]));

            int rowsAffected = session.createQuery(criteriaDelete).executeUpdate();
            transaction.commit();

            return rowsAffected > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Phone phone) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            session.merge(phone);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void close(){
        factory.close();
    }

    public Phone getPhoneWithHighestSellingPrice() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Phone> query = session.createQuery("FROM Phone ORDER BY Price DESC", Phone.class);
            query.setMaxResults(1);

            Phone phone = query.uniqueResult();

            transaction.commit();
            session.close();
            return phone;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Phone> getPhonesSortedByCountryAndPrice() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Phone> query = session.createQuery("FROM Phone ORDER BY Country ASC, Price DESC", Phone.class);

            List<Phone> phones = query.list();
            transaction.commit();
            session.close();
            return phones;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isPhonePricedAbove50Million() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Phone WHERE Price > 50000000", Long.class);

            Long count = query.uniqueResult();

            transaction.commit();
            session.close();
            return count > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public Phone getFirstPhoneWithPinkColorAndPriceOver15Million() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Phone> query = session.createQuery("FROM Phone WHERE Color = 'Pink' AND Price > 15000000", Phone.class);
            query.setMaxResults(1);

            Phone phone = query.uniqueResult();

            transaction.commit();
            session.close();
            return phone;
        } catch (Exception e) {
            return null;
        }
    }
}

