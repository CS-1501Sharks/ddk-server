package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepo extends JpaRepository<Student,Integer> {
}

