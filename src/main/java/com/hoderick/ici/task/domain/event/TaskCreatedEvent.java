package com.hoderick.ici.task.domain.event;

import org.springframework.modulith.NamedInterface;

import java.util.UUID;

@NamedInterface
public record TaskCreatedEvent(UUID taskId, UUID requesterId, double longitude, double latitude) {
}
