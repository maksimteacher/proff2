package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    private final Class<T> TYPE;

    public GenericDaoImpl(Class<T> type) {
        this.TYPE = type;
    }

    @Override
    public PK create(T newInstance) {
        PK id = null;
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            id = (PK) session.save(newInstance);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            throw he;
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public  T read(PK id) {
        T tableInstance = null;
        Session session = HibernateUtil.getSession();
        try {
            tableInstance = (T)session.get(TYPE, (Serializable) id);
        } catch (HibernateException he) {
            he.printStackTrace();
            throw he;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tableInstance;
    }

    @Override
    public void update(T transientObject) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(transientObject);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            throw he;
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T persistentObject) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(persistentObject);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            session.getTransaction().rollback();
            throw he;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> findAll() {
        return (List<T>)HibernateUtil.getSession().createCriteria(TYPE).list();
    }

    public List<T> findAllByForObRestrictionEq(String foreignOb, String foreignObProperty, String objectValue) {
        return (List<T>) HibernateUtil.getSession().createCriteria(TYPE)
                .createAlias(foreignOb, "fo")
                .add(Restrictions.eq("fo." + foreignObProperty, objectValue)).list();
    }

    public List<T> findAllByRestrictionEq(String propertyName, String objectValue) {
        return (List<T>) HibernateUtil.getSession().createCriteria(TYPE).add(Restrictions.eq(propertyName, objectValue)).list();
    }

    public T findByRestrictionEq(String propertyName, String objectValue) {
        return (T) HibernateUtil.getSession().createCriteria(TYPE).add(Restrictions.eq(propertyName, objectValue)).uniqueResult();
    }
}
