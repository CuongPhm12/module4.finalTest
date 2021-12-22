package com.example.md4finaltest.service.nation;

import com.example.md4finaltest.model.Nation;
import com.example.md4finaltest.repository.INationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class NationService implements INationService{
    @Autowired
    INationRepository nationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Optional<Nation> findById(Long id) {
        return nationRepository.findById(id);
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepository.save(nation);
    }

    @Override
    public void deleteById(Long id) {
        nationRepository.deleteById(id);

    }
}
