package com.example.md4finaltest.controller;

import com.example.md4finaltest.model.City;
import com.example.md4finaltest.model.Nation;
import com.example.md4finaltest.repository.ICityRepository;
import com.example.md4finaltest.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


    @Controller
    @RequestMapping("/nations")
    @CrossOrigin("*")
    public class NationController {
        @Autowired
        private ICityRepository cityService;

        @Autowired
        private INationService nationService;

        @GetMapping("/list")
        public ResponseEntity<Iterable<Nation>> listNation(){
            return new ResponseEntity<>(nationService.findAll(), HttpStatus.OK);
        }
        @PostMapping("/create")
        public ResponseEntity<Nation> createNation(@RequestBody Nation nation){
            nationService.save(nation);
            return new ResponseEntity<>(nation, HttpStatus.CREATED);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Nation> delete(@PathVariable Long id){
            nationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        @PutMapping("update/{id}")
        public ResponseEntity<Nation> updateNation(@PathVariable Long id, @RequestBody Nation nation){
            Optional<Nation> nationOptional = nationService.findById(id);
            if(!nationOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            nation.setId(nationOptional.get().getId());
            nationService.save(nation);
            return new ResponseEntity<>(nation, HttpStatus.OK);
        }

        @GetMapping("find/{id}")
        public ResponseEntity<Nation> findById(@PathVariable Long id){
            Optional<Nation> nationOptional = nationService.findById(id);
            if(!nationOptional.isPresent()){
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(nationOptional.get(),HttpStatus.OK);

        }

    }

