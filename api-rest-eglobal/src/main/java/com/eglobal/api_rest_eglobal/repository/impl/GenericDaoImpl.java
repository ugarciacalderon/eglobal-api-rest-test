package com.eglobal.api_rest_eglobal.repository.impl;

import com.eglobal.api_rest_eglobal.repository.GenericDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

    static Logger log = LoggerFactory.getLogger(GenericDaoImpl.class);

    private Class<T> classDomain = getClassDomain();

    public GenericDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public void update(T t) {
        try {
            getSession().update(t);
        } catch (HibernateException e) {
            throw new SecurityException(String.format("Se encontro un error al ejecutar Criteria de Hibernate", e.getMessage()));
        }
    }

    @Override
    public Serializable save(T t) {
        Serializable save = null;
        try {
            save = (Serializable) getSession().save(t);
        } catch (HibernateException e) {
            log.error("Error al guardar el objeto", e);
        }
        return save;
    }

    @Override
    public void delete(T t) {
        try {
            getSession().delete(t);
        } catch (HibernateException e) {
            log.error("Error al eliminar el objeto", e);
        }
    }

    @Override
    public void deleteById(Serializable id) {
        final T entidad = this.findById(id);
        this.delete(entidad);
    }

    @Override
    public T findById(final Serializable id) {
        T t = null;
        try {
            t = (T) getSession().get(classDomain.getName(), id);

        } catch (HibernateException e) {
            log.error("Error al consultar el objeto", e);
        }
        return t;
    }

    @Override
    public void update(List<T> objects) {
        for (T object : objects) {
            this.update(object);
        }
    }


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    private Class<T> getClassDomain() {
        if (classDomain == null) {
            ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            classDomain = (Class) thisType.getActualTypeArguments()[0];
        }
        return classDomain;
    }
}
