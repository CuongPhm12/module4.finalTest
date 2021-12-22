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
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityRepository cityService;

    @Autowired
    private INationService nationService;

    @ModelAttribute("nationList")
    public Iterable<Nation> nations(){
        return nationService.findAll();
    }


    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> listCity(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city){
        Optional<City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        Optional<City> cityOptional = cityService.findById(id);
        if(!cityOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.OK);

    }

}
