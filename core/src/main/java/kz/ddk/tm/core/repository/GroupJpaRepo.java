package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupJpaRepo extends JpaRepository<Group,Integer> {
}

