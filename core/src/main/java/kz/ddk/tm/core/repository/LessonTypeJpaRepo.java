package kz.ddk.tm.core.repository;

import kz.ddk.tm.core.module.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonTypeJpaRepo extends JpaRepository<LessonType, String> {

    List<LessonType> findAllByName(String name);
}
