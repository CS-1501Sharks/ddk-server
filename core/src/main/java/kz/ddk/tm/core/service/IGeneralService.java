package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.*;
import java.util.List;

public interface IGeneralService {
    List<Course> getAllCourse();
    List<Lesson> getLessonsByGroupId(Integer groupId);
    List<Lesson> getLessonsByRoomId(Integer roomId);

    public void saveCourse(Course course);

}
