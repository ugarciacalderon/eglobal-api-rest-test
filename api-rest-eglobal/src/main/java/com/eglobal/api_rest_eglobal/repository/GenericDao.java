package com.eglobal.api_rest_eglobal.repository;


import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {
    void update(T t);
    Serializable save(T t);
    void delete(T t);
    void deleteById(final Serializable id);
    void update(List<T> objects);
    T findById(final Serializable id);
}
