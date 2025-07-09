package com.hoderick.ici.matching.service;

import com.hoderick.ici.task.domain.event.TaskCreatedEvent;

public interface MatchingService {
    void findNearby(TaskCreatedEvent event);
}
