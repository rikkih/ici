package com.hoderick.ici.matching.service;

import com.hoderick.ici.task.domain.event.TaskCreatedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class MatchingServiceImpl implements MatchingService {

    @Override
    @ApplicationModuleListener
    public void findNearby(TaskCreatedEvent event) {
        
    }
}
