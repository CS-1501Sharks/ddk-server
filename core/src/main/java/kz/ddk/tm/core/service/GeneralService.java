package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.Course;
import kz.ddk.tm.core.module.Lesson;
import kz.ddk.tm.core.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService implements IGeneralService {

    @Autowired
    CourseJpaRepo courseJpaRepo;
    @Autowired
    LessonJpaRepo lessonJpaRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseJpaRepo.findAll();
    }

    @Override
    public List<Lesson> getLessonsByGroupId(Integer groupId) {
        return lessonJpaRepo.findAllByGroupId(groupId);
    }

    @Override
    public List<Lesson> getLessonsByRoomId(Integer roomId) {
        return lessonJpaRepo.findAllByRoomId(roomId);
    }

}
