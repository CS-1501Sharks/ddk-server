package kz.ddk.tm.core.repository;

import kz.ddk.tm.core.module.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineJpaRepo extends JpaRepository<Discipline,Integer> {
    List<Discipline> findAllByName(String name);
    List<Discipline> findAllByDisciplineTypeId(Integer disciplineTypeId);
}



