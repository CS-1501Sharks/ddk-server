package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeJpaRepo extends JpaRepository<RoomType,Integer> {
}



