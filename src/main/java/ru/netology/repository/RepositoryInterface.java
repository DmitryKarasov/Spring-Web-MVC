package ru.netology.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T> {

    List<T> all();

    Optional<T> getById(long id);

    void save(T post);

    void removeById(long id);

}
