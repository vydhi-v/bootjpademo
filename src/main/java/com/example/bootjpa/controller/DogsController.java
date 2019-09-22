package com.example.bootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootjpa.exceptions.DogNotFoundException;
import com.example.bootjpa.model.DogDto;
import com.example.bootjpa.repo.Dog;
import com.example.bootjpa.service.DogsService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
@Setter
public class DogsController {
    @Autowired private final DogsService service;

    @GetMapping
    public List<Dog> getDogs() {
        return service.getDogs();
    }

    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) throws DogNotFoundException {
        return service.getDogById(id);
    }
    
    @PreAuthorize("#oauth2.hasScope('profile')")
    @PostMapping
    public void postDogs(@RequestBody DogDto dog) {
        service.add(dog);
    }
    @PreAuthorize("#oauth2.hasScope('profile')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}