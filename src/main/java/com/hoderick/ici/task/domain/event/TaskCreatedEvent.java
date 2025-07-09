package com.hoderick.ici.task.domain.event;

import java.util.UUID;

public record TaskCreatedEvent(UUID taskId, UUID requesterId, double longitude, double latitude) {
}
