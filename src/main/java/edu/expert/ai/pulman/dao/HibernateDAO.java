package edu.expert.ai.pulman.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

public abstract class HibernateDAO extends HibernateManager{



    protected Session getCurrentSession() {
        return getSession();
    }

    public HibernateDAO()
    {}

    @Transactional
    public void executeQuery(String query, Object[] obj) {

        Transaction transaction=getSession().beginTransaction();
        getCurrentSession().createSQLQuery(query).executeUpdate();
    }

    @Transactional(readOnly = true)
    public Object executeSelectQuery(String query) {
        return getCurrentSession().createSQLQuery(query).uniqueResult();
    }

    @Transactional
    public Query createQuery(String query) {
        return getCurrentSession().createQuery(query);
    }

    @Transactional
    public Query createSQLQuery(String query) {
        return getCurrentSession().createSQLQuery(query);
    }

    @Transactional
    public void delete(Object object) {

        getCurrentSession().delete(object);
    }

    @Transactional
    public void save(Object object) {

        getCurrentSession().save(object);
    }

    @Transactional
    public void saveOrUpdate(Object object) {

        getCurrentSession().saveOrUpdate(object);

    }

    @Transactional(readOnly = true)
    public Object get(BigInteger id, Class clazz) {

        return id == null ? null : getCurrentSession().get(clazz, id);
    }
}