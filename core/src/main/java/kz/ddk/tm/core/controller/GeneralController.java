package kz.ddk.tm.core.controller;


import kz.ddk.tm.core.module.Course;
import kz.ddk.tm.core.module.Lesson;
import kz.ddk.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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
    @GetMapping("/lesson/byroom/{id}")
    List<Lesson> getAllByRoomId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByRoomId(id);
    }
    @GetMapping("/lesson/bygroup/{id}")
    List<Lesson> getAllByGroupId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByGroupId(id);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course, BindingResult bindingResult,
                                          UriComponentsBuilder ucBuilder) {
        this.service.saveCourse(course);
        return new ResponseEntity<Course>(course, HttpStatus.CREATED);
    }


}

