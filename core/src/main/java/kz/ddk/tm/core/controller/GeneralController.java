package kz.ddk.tm.core.controller;


import kz.ddk.tm.core.module.Course;
import kz.ddk.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {
    @Autowired
    IGeneralService service;

    @GetMapping("/course")
    List<Course> getAllCourse(){
        return  service.getAllCourse();
    }


}

