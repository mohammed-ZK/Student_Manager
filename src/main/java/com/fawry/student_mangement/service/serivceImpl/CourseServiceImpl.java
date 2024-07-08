package com.fawry.student_mangement.service.serivceImpl;

import com.fawry.student_mangement.entity.Course;
import com.fawry.student_mangement.repository.CourseRepo;
import com.fawry.student_mangement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course update(Course course,Long id) {
        Course course1=courseRepo.findById(id).get();
        course1.setName(course.getName());
        courseRepo.save(course1);
        return course1;
    }

    @Override
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course get(Long id) {
        return courseRepo.findById(id).get();
    }
}
