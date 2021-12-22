package com.example.md4finaltest.service;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void deleteById(Long id);
}
