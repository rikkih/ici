package com.hoderick.ici.location.service;

import com.hoderick.ici.location.dto.NearbyUserLocation;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    void updateLocation(UUID userId, double longitude, double latitude);
    List<NearbyUserLocation> findNearby(double longitude, double latitude, double radiusKm);
}
