package com.springboot.courseapi.topic.repository;

import com.springboot.courseapi.topic.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}