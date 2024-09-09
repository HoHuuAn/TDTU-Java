package com.hohuuan;

import jakarta.persistence.NoResultException;
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

public class ManufactureDAO {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Phone.class)
            .addAnnotatedClass(Manufacture.class)
            .buildSessionFactory();

    public boolean add(Manufacture manufacture) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            session.persist(manufacture);

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Manufacture get(String id) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            Manufacture manufacture = session.get(Manufacture.class, id);

            transaction.commit();
            session.close();
            return manufacture;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Manufacture> getAll() {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            List<Manufacture> list = session.createQuery("FROM Manufacture", Manufacture.class).list();

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
            Manufacture manufacture = session.get(Manufacture.class, id);
            if (manufacture != null) {
                session.remove(manufacture);
                session.flush();
                transaction.commit();
                session.close();
                return true;
            }

            transaction.commit();
            session.close();
            return false;
        } catch (Exception e) {
            return false;
        }
    }

        public boolean remove(Manufacture manufacture) {
        Session session = factory.getCurrentSession();
        Transaction transaction;
        try {
            transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<Manufacture> criteriaDelete = criteriaBuilder.createCriteriaDelete(Manufacture.class);
            Root<Manufacture> root = criteriaDelete.from(Manufacture.class);


            List<Predicate> predicates = new ArrayList<>();
            for (Field field : manufacture.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(manufacture);
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

    public boolean update(Manufacture manufacture) {
        Transaction transaction;
        try (Session session = factory.getCurrentSession()) {
            transaction = session.beginTransaction();

            session.update(manufacture);

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

    public boolean areAllManufacturersMoreThan100Employees() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Manufacture WHERE Employee <= 100", Long.class);

            Long count = query.uniqueResult();

            transaction.commit();
            session.close();
            return count == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public int getTotalEmployeesOfManufacturers() {
        try (Session session = factory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Query<Long> query = session.createQuery("SELECT SUM(Employee) FROM Manufacture", Long.class);

            Long sum = query.uniqueResult();

            transaction.commit();
            session.close();
            return sum != null ? sum.intValue() : 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public Manufacture getLastManufacturerBasedInUS() {
         Session session = factory.getCurrentSession();
         Transaction transaction = session.beginTransaction();

         Query<Manufacture> query = session.createQuery("FROM Manufacture WHERE Location = 'US' ORDER BY ID DESC", Manufacture.class);
         query.setMaxResults(1);

            Manufacture manufacturer;
            try {
                manufacturer = query.getSingleResult();
            } catch (NoResultException e) {
                throw new InvalidOperationException("No manufacturer based in the US found.");
            }

            transaction.commit();
            return manufacturer;

    }
}
