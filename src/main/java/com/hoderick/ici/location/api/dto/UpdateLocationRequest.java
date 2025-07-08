package com.hoderick.ici.location.api.dto;

import java.util.UUID;

public record UpdateLocationRequest(UUID userId, double longitude, double latitude) {
}
