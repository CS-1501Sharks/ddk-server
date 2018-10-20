package kz.ddk.tm.core.repository;

import kz.ddk.tm.core.module.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonTypeJpaRepo extends JpaRepository<LessonType, Integer> {

}
