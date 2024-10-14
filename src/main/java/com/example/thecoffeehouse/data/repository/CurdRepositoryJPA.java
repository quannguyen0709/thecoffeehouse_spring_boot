package com.example.thecoffeehouse.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CurdRepositoryJPA<Object, KeyType> extends Repository<Object, KeyType> {
    <S extends Object> S save(S entity);

    <S extends Object> List<S> saveAll(Iterable<S> entities);

    Optional<Object> findById(KeyType id);

    boolean existsById(KeyType id);

    List<Object> findAll();

    List<Object> findAllById(Iterable<KeyType> ids);

    long count();

    void deleteById(KeyType id);

    void delete(Object entity);

    void deleteAllById(Iterable<? extends KeyType> ids);

    void deleteAll(Iterable<? extends Object> entities);

    void deleteAll();
}
