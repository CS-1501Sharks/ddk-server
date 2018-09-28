package kz.ddk.tm.core.service;
import kz.ddk.tm.core.module.Course;
import kz.ddk.tm.core.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService implements IGeneralService {

    @Autowired
    CourseJpaRepo courseJpaRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseJpaRepo.findAll();
    }

}
