package com.example.ecommerce.interfaces;

public interface BaseRepositoryInterface<T> {

    void add(T entity);
    void update(T entity);
    void delete(T entity);


}
