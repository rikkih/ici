package com.hoderick.ici.location;

import com.hoderick.ici.location.dto.NearbyUserLocation;

import java.util.List;

public interface PublicLocationService {
    List<NearbyUserLocation> findNearby(double longitude, double latitude, double radiusKm);
}
