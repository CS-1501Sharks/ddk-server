package kz.ddk.tm.core.controller;
import kz.ddk.tm.core.module.*;
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

    /*GET METHODS*/
    //Course
    @GetMapping("/course")
    List<Course> getAllCourse(){
        return  service.getAllCourse();
    }
    @GetMapping("/course/byTeacher/{id}")
    List<Course> getAllByTeacherId(@PathVariable(value = "id") Integer id){
        return service.getCourseByTeacherId(id);
    }
    @GetMapping("/course/byDiscipline/{id}")
    List<Course> getAllByDisciplineId(@PathVariable(value = "id") Integer id){
        return service.getCourseByDisciplineId(id);
    }
    @GetMapping("/course/byGroup/{id}")
    List<Course> getAllByGroupID(@PathVariable(value = "id") Integer id){
        return service.getCourseByGroupId(id);
    }
    @GetMapping("/course/byGroupLead/{id}")
    List<Course> getAllByGroupLeadId(@PathVariable(value = "id") Integer id){
        return service.getCourseByGroupLeadId(id);
    }

    //Discipline
    @GetMapping("/discipline/byName")
    List<Discipline> getAllByName(@PathVariable(value = "name") String name){
        return service.getDisciplineByName(name);
    }
    @GetMapping("/discipline/byDisciplineType/{id}")
    List<Discipline> getAllByDisciplineTypeId(@PathVariable(value = "id") Integer id){
        return service.getDisciplineByDisciplineTypeID(id);
    }

    //DisciplineType
    @GetMapping("/disciplineType/byName")
    List<DisciplineType> getAllByNamE(@PathVariable(value = "name") String name){
        return service.getDisciplineTypeByName(name);
    }

    //Group
    @GetMapping("/group/byName")
    List<Group> getAllByNaMe(@PathVariable(value = "name") String name){
        return service.getGroupByName(name);
    }
    @GetMapping("/group/byClassroomNum")
    List<Group> getAllByClassroomNum(@PathVariable(value = "classroomNum") Integer classroomNum){
        return service.getGroupByClassroomNum(classroomNum);
    }

    //Lesson
    @GetMapping("/lesson/byRoom/{id}")
    List<Lesson> getAllByRoomId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByRoomId(id);
    }
    @GetMapping("/lesson/byGroup/{id}")
    List<Lesson> getAllByGroupId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByGroupId(id);
    }
    @GetMapping("/lesson/byCourse/{id}")
    List<Lesson> getAllByCourseId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByCourseId(id);
    }
    @GetMapping("/lesson/byType/{id}")
    List<Lesson> getAllByTypeId(@PathVariable(value = "id") Integer id){
        return service.getLessonsByTypeId(id);
    }

    //LessonType
    @GetMapping("/lessonType/byName")
    List<LessonType> getAllByNAme(@PathVariable(value = "name") String name){
        return service.getLessonTypeByName(name);
    }

    //Room
    @GetMapping("/room/byName")
    List<Room> getAllByNaME(@PathVariable(value = "name") String name){
        return service.getRoomByName(name);
    }
    @GetMapping("/room/byFloor")
    List<Room> getAllByFloor(@PathVariable(value = "floor") Integer floor){
        return service.getRoomByFloor(floor);
    }
    @GetMapping("/room/byNumber")
    List<Room> getAllByNumber(@PathVariable(value = "number") Integer number){
        return service.getRoomByNumber(number);
    }













    /*POST Methods*/
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Course> addCourse(@RequestBody @Valid Course course, BindingResult bindingResult,
//                                          UriComponentsBuilder ucBuilder) {
//        this.service.saveCourse(course);
//        return new ResponseEntity<Course>(course, HttpStatus.CREATED);
//    }
    @RequestMapping(value = "/discipline", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Discipline> saveDiscipline(@RequestBody @Valid Discipline discipline, BindingResult bindingResult,
                                                UriComponentsBuilder ucBuilder) {
        this.service.saveDiscipline(discipline);
        return new ResponseEntity<Discipline>(discipline, HttpStatus.CREATED);
    }





    /*PUT Methods*/
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




    /*DELETE Methods*/
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
}

