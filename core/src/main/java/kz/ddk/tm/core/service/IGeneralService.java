package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.*;
import java.util.List;

public interface IGeneralService {
    List<Course> getAllCourse();
    List<Lesson> getLessonsByGroupId(Integer groupId);
    List<Lesson> getLessonsByRoomId(Integer roomId);
    List<Lesson> getLessonsByCourseId(Integer courseId);
    List<Lesson> getLessonsByTypeId(Integer TypeId);
    Discipline getDisciplineById(Integer disciplineId);

    public void saveCourse(Course course);
    public void saveDiscipline(Discipline discipline) ;
    public void deleteDiscipline(Discipline discipline) ;

}
