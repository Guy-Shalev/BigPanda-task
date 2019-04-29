package com.BigPanda.BigPandatask.model;

import java.util.concurrent.ConcurrentHashMap;

public class EventTracker {
    private ConcurrentHashMap<String, Integer> eventsByType = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> words = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, Integer> getEventsByType() {
        return eventsByType;
    }

    public void setEventByType(String eventByType) {
        this.eventsByType.put(eventByType, this.eventsByType.getOrDefault(eventByType, 0) + 1);
    }

    public ConcurrentHashMap<String, Integer> getWords() {
        return words;
    }

    public void setWord(String word) {
        this.words.put(word, this.words.getOrDefault(word, 0) + 1);
    }


}
