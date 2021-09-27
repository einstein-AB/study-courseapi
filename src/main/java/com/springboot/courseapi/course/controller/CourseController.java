package com.springboot.courseapi.course.controller;

import com.springboot.courseapi.course.model.Course;
import com.springboot.courseapi.course.service.CourseService;
import com.springboot.courseapi.topic.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        logger.info("Reading all the courses");
        return courseService.getAllCourses();
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable(name = "courseId") String courseId) {
        return courseService.getCourseById(courseId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.PUT)
    public void updateTopic(@PathVariable String topicId, @RequestBody Course course) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}", method = RequestMethod.DELETE)
    public void deleteTopicById(@PathVariable(name = "courseId") String courseId) {
        courseService.deleteCourseById(courseId);
    }


}
