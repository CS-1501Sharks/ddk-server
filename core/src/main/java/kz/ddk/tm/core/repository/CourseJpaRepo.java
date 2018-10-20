package kz.ddk.tm.core.repository;

import kz.ddk.tm.core.module.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseJpaRepo extends JpaRepository<Course,Integer> {
    List<Course> findAllByTeacherId(Integer teacherId);
    List<Course> findAllByDisciplineId(Integer disciplineId);
    List<Course> findAllByGroupId(Integer groupId);
    List<Course> findAllByGroupLeadId(Integer groupLeadId);

}


