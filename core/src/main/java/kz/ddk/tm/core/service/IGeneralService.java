package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.*;
import java.util.List;

public interface IGeneralService {
    List<Course> getAllCourse();
    List<Course> getCourseByTeacherId(Integer teacherId);
    List<Course> getCourseByDisciplineId(Integer disciplineId);
    List<Course> getCourseByGroupId(Integer groupId);
    List<Course> getCourseByGroupLeadId(Integer groupLeadId);
    List<Discipline> getDisciplineByName(String name);
    List<Discipline> getDisciplineByDisciplineTypeID(Integer disciplineTypeId);
    List<Lesson> getLessonsByGroupId(Integer groupId);
    List<Lesson> getLessonsByRoomId(Integer roomId);
    List<Lesson> getLessonsByCourseId(Integer courseId);
    List<Lesson> getLessonsByTypeId(Integer TypeId);
    Discipline getDisciplineById(Integer disciplineId);

    public void saveCourse(Course course);
    public void saveDiscipline(Discipline discipline) ;
    public void deleteDiscipline(Discipline discipline) ;

}
