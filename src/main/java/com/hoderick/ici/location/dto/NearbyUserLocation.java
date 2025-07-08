package com.hoderick.ici.location.dto;

import java.util.UUID;

public record NearbyUserLocation(String id, double longitude, double latitude, Double distanceKm) {
}
