package com.hoderick.ici.matching.service;

import com.hoderick.ici.location.PublicLocationService;
import com.hoderick.ici.task.domain.event.TaskCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

    private final PublicLocationService locationService;

    @Override
    @ApplicationModuleListener
    public void findNearby(TaskCreatedEvent event) {
        
    }
}
