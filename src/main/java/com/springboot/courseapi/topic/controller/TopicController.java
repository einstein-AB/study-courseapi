package com.springboot.courseapi.topic.controller;

import com.springboot.courseapi.topic.model.Topic;
import com.springboot.courseapi.topic.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        logger.info("Reading all the topics");
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopicsById(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopicById(@PathVariable(name = "id") String id) {
        topicService.deleteTopicById(id);
    }
}
