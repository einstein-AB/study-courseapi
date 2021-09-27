package com.springboot.courseapi.course.repository;

import com.springboot.courseapi.course.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByTopicId(String id);
}
