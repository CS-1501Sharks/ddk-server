package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.*;
import kz.ddk.tm.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService implements IGeneralService {

    @Autowired
    CourseJpaRepo courseJpaRepo;
    @Autowired
    DisciplineJpaRepo disciplineJpaRepo;
    @Autowired
    DisciplineTypeJpaRepo disciplineTypeJpaRepo;
    @Autowired
    GroupJpaRepo groupJpaRepo;
    @Autowired
    LessonJpaRepo lessonJpaRepo;
    @Autowired
    LessonTypeJpaRepo lessonTypeJpaRepo;
    @Autowired
    RoomJpaRepo roomJpaRepo;
    @Autowired
    RoomTypeJpaRepo roomTypeJpaRepo;
    @Autowired
    StudentJpaRepo studentJpaRepo;
    @Autowired
    TeacherJpaRepo teacherJpaRepo;
    @Autowired
    UserJpaRepo userJpaRepo;



    /*GET Methods*/
    //Course
    @Override
    public List<Course> getAllCourse() {
        return courseJpaRepo.findAll();
    }

    @Override
    public List<Course> getCourseByTeacherId(Integer teacherId) {
        return courseJpaRepo.findAllByTeacherId(teacherId);
    }

    @Override
    public List<Course> getCourseByDisciplineId(Integer disciplineId) {
        return courseJpaRepo.findAllByDisciplineId(disciplineId);
    }

    @Override
    public List<Course> getCourseByGroupId(Integer groupId) {
        return courseJpaRepo.findAllByGroupId(groupId);
    }

    @Override
    public List<Course> getCourseByGroupLeadId(Integer groupLeadId) {
        return courseJpaRepo.findAllByGroupLeadId(groupLeadId);
    }


    //Discipline
    @Override
    public List<Discipline> getDisciplineByName(String name) {
        return disciplineJpaRepo.findAllByName(name);
    }

    @Override
    public List<Discipline> getDisciplineByDisciplineTypeID(Integer disciplineTypeId) {
        return disciplineJpaRepo.findAllByDisciplineTypeId(disciplineTypeId);
    }


    //DisciplineType
    @Override
    public List<DisciplineType> getDisciplineTypeByName(String name) {
        return disciplineTypeJpaRepo.findAllByName(name);
    }


    //Group
    @Override
    public List<Group> getGroupByName(String name) {
        return groupJpaRepo.findAllByName(name);
    }

    @Override
    public List<Group> getGroupByClassroomNum(Integer classroomNum) {
        return groupJpaRepo.findAllByClassroomNum(classroomNum);
    }


    //Lesson
    @Override
    public List<Lesson> getLessonsByGroupId(Integer groupId) {
        return lessonJpaRepo.findAllByGroupId(groupId);
    }

    @Override
    public List<Lesson> getLessonsByRoomId(Integer roomId) {
        return lessonJpaRepo.findAllByRoomId(roomId);
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Integer courseId) {
        return lessonJpaRepo.findAllByCourseId(courseId);
    }

    @Override
    public List<Lesson> getLessonsByTypeId(Integer typeId) {
        return lessonJpaRepo.findAllByTypeId(typeId);
    }


    //LessonType
    @Override
    public List<LessonType> getLessonTypeByName(String name) {
        return lessonTypeJpaRepo.findAllByName(name);
    }


    //Room
    @Override
    public List<Room> getRoomByName(String name) {
        return roomJpaRepo.findAllByName(name);
    }

    @Override
    public List<Room> getRoomByFloor(Integer floor) {
        return roomJpaRepo.findAllByFloor(floor);
    }

    @Override
    public List<Room> getRoomByNumber(Integer number) {
        return roomJpaRepo.findAllByNumber(number);
    }

    
    //Check this?
    @Override
    public Discipline getDisciplineById(Integer disciplineId) {
        return  disciplineJpaRepo.findOne(disciplineId);
    }

    /*POST method*/
    public void saveCourse(Course course){
        courseJpaRepo.save(course);
    }

    @Override
    public void saveDiscipline(Discipline discipline) {
        disciplineJpaRepo.save(discipline);
    }

    /*DELETE Method*/
    @Override
    public void deleteDiscipline(Discipline discipline) {
        disciplineJpaRepo.delete(discipline);
    }


}
