package com.fawry.student_mangement.resource;

import com.fawry.student_mangement.entity.Student;
import com.fawry.student_mangement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id){
        return studentService.get(id);
    }

    @PostMapping()
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student,@PathVariable Long id) {
        return studentService.update(student,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping()
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping("/{id}/courses")
    public ResponseEntity<?> addUserCourses(@PathVariable long id, @RequestBody List<Long> courseIds) {
        try {
            studentService.addStudentCourses(id, courseIds);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
