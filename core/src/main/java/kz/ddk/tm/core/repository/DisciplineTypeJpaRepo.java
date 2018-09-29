package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.DisciplineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineTypeJpaRepo extends JpaRepository<DisciplineType,Integer> {
}

