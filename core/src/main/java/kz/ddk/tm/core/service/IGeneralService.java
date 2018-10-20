package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.*;
import java.util.List;

public interface IGeneralService {
    List<Course> getAllCourse();
    Discipline getDisciplineById(Integer disciplineId);
    List<Lesson> getLessonsByGroupId(Integer groupId);
    List<Lesson> getLessonsByRoomId(Integer roomId);

    public void saveCourse(Course course);
    public void saveDiscipline(Discipline discipline) ;
    public void deleteDiscipline(Discipline discipline) ;

}
