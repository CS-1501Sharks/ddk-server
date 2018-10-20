package kz.ddk.tm.core.repository;

import kz.ddk.tm.core.module.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonJpaRepo extends JpaRepository<Lesson, Integer> {

    List<Lesson> findAllByGroupId(Integer groupId);
    List<Lesson> findAllByRoomId(Integer roomId);
    List<Lesson> findAllByCourseId(Integer courseId);
    List<Lesson> findAllByTypeId(Integer typeId);
}
