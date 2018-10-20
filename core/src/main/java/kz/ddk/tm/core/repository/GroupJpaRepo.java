package kz.ddk.tm.core.repository;
import kz.ddk.tm.core.module.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupJpaRepo extends JpaRepository<Group,Integer> {

    List<Group> findAllByName(String name);
    List<Group> findAllByClassroomNum(Integer classroomNum);

}

