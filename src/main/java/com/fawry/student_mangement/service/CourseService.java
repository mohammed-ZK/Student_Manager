package com.fawry.student_mangement.service;


import com.fawry.student_mangement.entity.Course;

import java.util.List;

public interface CourseService {
    public Course save(final Course course);
    public Course update(final Course course,final Long id);
    public void delete(final Long id);
    public List<Course> getAll();
    public Course get(Long id);
}
