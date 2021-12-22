package com.example.md4finaltest.repository;

import com.example.md4finaltest.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INationRepository extends JpaRepository<Nation,Long> {
}
