package kz.ddk.tm.core.controller;

import kz.ddk.tm.core.module.Course;
import kz.ddk.tm.core.module.Discipline;
import kz.ddk.tm.core.module.Lesson;
import kz.ddk.tm.core.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course, BindingResult bindingResult,
//                                          UriComponentsBuilder ucBuilder) {
//        this.service.saveCourse(course);
//        return new ResponseEntity<Course>(course, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody @Valid Discipline discipline, BindingResult bindingResult,
                                                UriComponentsBuilder ucBuilder) {
        this.service.saveDiscipline(discipline);
        return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{disciplineId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Void> deleteDiscipline(@PathVariable("disciplineId") int disciplineId) {
        Discipline discipline = this.service.getDisciplineById(disciplineId);
        if (discipline == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.service.deleteDiscipline(discipline);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/{disciplineId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable("disciplineId") int disciplineId, @RequestBody @Valid Discipline discipline,
                                                       BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        HttpHeaders headers = new HttpHeaders();
        if (discipline == null) {
            return new ResponseEntity<Discipline>(headers, HttpStatus.BAD_REQUEST);
        }
        Discipline currentDiscipline = this.service.getDisciplineById(disciplineId);
        if (currentDiscipline == null) {
            return new ResponseEntity<Discipline>(HttpStatus.NOT_FOUND);
        }

        currentDiscipline.setName(discipline.getName());

        this.service.saveDiscipline(currentDiscipline);
        return new ResponseEntity<Discipline>(currentDiscipline, HttpStatus.NO_CONTENT);
    }


}

