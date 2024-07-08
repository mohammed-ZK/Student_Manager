package com.fawry.student_mangement.service;

import com.fawry.student_mangement.entity.Student;

import java.util.List;

public interface StudentService {
    public Student save(final Student student);
    public Student update(final Student student ,final Long id);
    public void delete(final Long id);
    public List<Student> getAll();
    public Student get(Long id);
    public void addStudentCourses(Long id, List<Long> courseIds);
}
