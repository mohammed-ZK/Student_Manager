package com.fawry.student_mangement.service.serivceImpl;

import com.fawry.student_mangement.entity.Course;
import com.fawry.student_mangement.entity.Student;
import com.fawry.student_mangement.repository.CourseRepo;
import com.fawry.student_mangement.repository.StudentRepo;
import com.fawry.student_mangement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student update(Student student,Long id) {
        Student student1=studentRepo.findById(id).get();
        student1.setName(student.getName());
        studentRepo.save(student1);
        return student1;
    }

    @Override
    public void delete(Long id) {

        studentRepo.deleteById(id);

    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student get(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void addStudentCourses(Long id, List<Long> courseIds) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            List<Course> courses = courseRepo.findAllById(courseIds);
            student.getCourses().addAll(courses);
            studentRepo.save(student);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
