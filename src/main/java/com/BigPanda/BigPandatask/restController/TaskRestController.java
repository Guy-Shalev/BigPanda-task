package com.BigPanda.BigPandatask.restController;

import com.BigPanda.BigPandatask.model.EventTracker;
import com.BigPanda.BigPandatask.observer.TaskObserver;
import com.BigPanda.BigPandatask.service.TaskService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private static Logger log = LoggerFactory.getLogger(TaskRestController.class);

    @Autowired
    private EventTracker eventTrackerSingleton;

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/getTaskResponse")
    public String getTaskResponse() throws Exception {

        Observable.interval(1000, TimeUnit.MILLISECONDS,Schedulers.io())
                .map(tick ->   taskService.getResponse())
                .subscribe(new TaskObserver());

        return "Words: " + eventTrackerSingleton.getWords().toString() + "\n Event type: " + eventTrackerSingleton.getEventsByType().toString();
    }
}
