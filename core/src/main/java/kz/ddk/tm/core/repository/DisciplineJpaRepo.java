package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineJpaRepo extends JpaRepository<Discipline,Integer> {
}



