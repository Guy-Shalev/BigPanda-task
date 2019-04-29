package com.BigPanda.BigPandatask.observer;

import com.BigPanda.BigPandatask.model.EventTracker;
import com.BigPanda.BigPandatask.model.TaskResponse;
import io.reactivex.observers.DefaultObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class TaskObserver extends DefaultObserver {
    private static Logger log = LoggerFactory.getLogger(TaskObserver.class);

    @Autowired
    private EventTracker eventTrackerSingleton;

    @Override
    public void onNext(Object o) {
        Mono<TaskResponse> responseMono = (Mono<TaskResponse>) o;

        responseMono.subscribe(
                taskResponse -> {
                    if (eventTrackerSingleton != null) {
                        if (taskResponse.getEvent().getData() != null) {
                            eventTrackerSingleton.setWord(taskResponse.getEvent().getData());
                        }
                        if (taskResponse.getEvent().getEvent_type() != null) {
                            eventTrackerSingleton.setEventByType(taskResponse.getEvent().getEvent_type());
                        }
                        System.out.println("Words: " + eventTrackerSingleton.getWords().toString() + "\n Event type: " + eventTrackerSingleton.getEventsByType().toString());
                    }
                }
        );
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Error: " + throwable.toString());
    }

    @Override
    public void onComplete() {

    }
}
