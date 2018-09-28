package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJpaRepo extends JpaRepository<Course,Integer> {
}


