package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJpaRepo extends JpaRepository<Teacher,Integer> {
}

