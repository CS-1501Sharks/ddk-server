package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<User,Integer> {
}

