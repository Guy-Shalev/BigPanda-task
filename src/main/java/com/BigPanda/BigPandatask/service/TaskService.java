package com.BigPanda.BigPandatask.service;

import com.BigPanda.BigPandatask.model.TaskResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface TaskService {

    Mono<TaskResponse> getResponse() throws IOException;
}
