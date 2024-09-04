package ru.netology.service;

import java.util.List;

public interface ServiceInterface<T> {

    List<T> all();

    T getById(long id);

    void save(T post);

    void removeById(long id);

}
