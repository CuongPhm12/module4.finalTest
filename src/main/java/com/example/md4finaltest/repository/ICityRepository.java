package com.example.md4finaltest.repository;

import com.example.md4finaltest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ICityRepository extends JpaRepository<City,Long> {
}
