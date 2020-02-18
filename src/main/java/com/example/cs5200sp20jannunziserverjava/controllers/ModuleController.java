package com.example.cs5200sp20jannunziserverjava.controllers;

import com.example.cs5200sp20jannunziserverjava.models.*;
import com.example.cs5200sp20jannunziserverjava.repositories.CourseRepository;
import com.example.cs5200sp20jannunziserverjava.repositories.ModuleRepository;
import com.example.cs5200sp20jannunziserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;
import java.util.Optional;

@RestController
public class ModuleController {

    @Autowired
    ModuleRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    WidgetRepository widgetRepository;

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

    @GetMapping("/courses")
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @GetMapping("/addModuleToCourse")
    public Course addModuleToCourse() {
        Course microGreensCourse = courseRepository.findById(1).get();

        Module seedingModule = new Module();
        seedingModule.setTitle("Seeding Module");
        Module germinatingModule = new Module();
        germinatingModule.setTitle("Germinating");

        microGreensCourse.addModule(seedingModule);
        microGreensCourse.addModule(germinatingModule);

//        courseRepository.save(microGreensCourse);
        repository.save(seedingModule);
        repository.save(germinatingModule);

        return microGreensCourse;
//        Course webdev = courseRepository.findById(4).get();
//        Module angular = repository.findModuleById(10);
//
////        webdev.getModules().add(angular);
//        angular.setCourse(webdev);
//
//        repository.save(angular);
//        return webdev;
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

    @GetMapping("/createWidgets")
    public void createWidgets() {
        Widget w1 = new Widget();
        w1.setName("Widget 1");
        widgetRepository.save(w1);

        HtmlWidget w3 = new HtmlWidget();
        w3.setName("Html Widget");
        w3.setHtml("<h1>Hello World</h1>");
        w3.setClassName("pretty");
        widgetRepository.save(w3);

        YouTubeWidget w2 = new YouTubeWidget();
        w2.setName("YouTube Widget");
        w2.setEmbeddable(true);
        w2.setUrl("http://the/url/of/widget");
        widgetRepository.save(w2);
    }
}
