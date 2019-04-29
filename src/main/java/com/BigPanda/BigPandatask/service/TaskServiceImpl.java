package com.BigPanda.BigPandatask.service;

import com.BigPanda.BigPandatask.model.Event;
import com.BigPanda.BigPandatask.model.EventTracker;
import com.BigPanda.BigPandatask.model.TaskResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class TaskServiceImpl implements TaskService {
    private static Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EventGenerator eventGeneratorSingleton;

    @Autowired
    private EventTracker eventTrackerSingleton;

    @Override
    public Mono<TaskResponse> getResponse() throws IOException {
        TaskResponse taskResponse = new TaskResponse();

        try {
            taskResponse.setEvent(objectMapper.readValue(eventGeneratorSingleton.getEvent(), Event.class));
        } catch (Exception e) {
            taskResponse.setEvent(objectMapper.readValue(eventGeneratorSingleton.getEvent(), Event.class));
        }
        eventTrackerSingleton.setWord(taskResponse.getEvent().getData());
        eventTrackerSingleton.setEventByType(taskResponse.getEvent().getEvent_type());
        System.out.println("Words: " + eventTrackerSingleton.getWords().toString() + "\n Event type: " + eventTrackerSingleton.getEventsByType().toString());

        return Mono.just(taskResponse);
    }
}
