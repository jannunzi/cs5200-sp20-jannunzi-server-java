package com.example.cs5200sp20jannunziserverjava.controllers;

import com.example.cs5200sp20jannunziserverjava.models.Module;
import com.example.cs5200sp20jannunziserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ModuleController {
    @Autowired
    ModuleRepository repository;

    @GetMapping("/createmodule")
    public Module createModule() {
        Module nonSql = new Module();
        nonSql.setTitle("NonSQL");
        // INSERT
        return repository.save(nonSql);
    }

    @GetMapping("/deletemodule/1")
    public void deleteModule() {
        repository.deleteById(1);
    }

    @GetMapping("/updatemodule/3")
    public Module updateModule() {
        Module jdbc = repository.findModuleById(3);
        jdbc.setTitle("Java Database Connectivity");
        jdbc.setModuleDescription("Low level SQL communication from Java");
        // UPDATE
        return repository.save(jdbc);
    }

    @GetMapping("/modules")
    public List<Module> findAllModules() {
//        return (List<Module>)repository.findAll();
        return repository.findAllModules();
    }

    @GetMapping("/modules/2")
    public Module findModuleById() {
//        Optional<Module> moduleMaybe = repository.findById(2);
//        if(moduleMaybe.isPresent()) {
//            return moduleMaybe.get();
//        }
//        return null;
        Module m = repository.findModuleById(1);
        return m;
    }
}
