package com.springboot.courseapi.topic.service;

import com.springboot.courseapi.topic.model.Topic;
import com.springboot.courseapi.topic.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach((topic) -> topicList.add(topic));
        return topicList;
    }

    public Topic getTopicById(String id) {
        return topicRepository.findById(id).orElseGet(() -> new Topic());
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopicById(String id) {
        topicRepository.deleteById(id);
    }

}
