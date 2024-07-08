package com.fawry.student_mangement.resource;

import com.fawry.student_mangement.entity.Course;
import com.fawry.student_mangement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id){
        return courseService.get(id);
    }

    @PostMapping()
    public Course save(@RequestBody Course Course) {
        return courseService.save(Course);
    }

    @PutMapping("/{id}")
    public Course update(@RequestBody Course Course,@PathVariable Long id) {
        return courseService.update(Course,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @GetMapping()
    public List<Course> getAll() {
        return courseService.getAll();
    }
}
