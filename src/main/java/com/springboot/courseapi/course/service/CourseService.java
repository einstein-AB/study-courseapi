package com.springboot.courseapi.course.service;

import com.springboot.courseapi.course.model.Course;
import com.springboot.courseapi.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach((course) -> courseList.add(course));
        return courseList;
    }

    public Course getCourseById(String courseId) {
        return courseRepository.findById(courseId).orElseGet(() -> new Course());
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }

}
