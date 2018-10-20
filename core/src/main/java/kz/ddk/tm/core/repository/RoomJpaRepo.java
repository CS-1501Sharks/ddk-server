package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomJpaRepo extends JpaRepository<Room,Integer> {
    List<Room> findAllByName(String name);
    List<Room> findAllByFloor(Integer floor);
    List<Room> findAllByNumber(Integer number);

}

