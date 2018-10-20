package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomJpaRepo extends JpaRepository<Room,Integer> {
}

