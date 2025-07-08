package com.hoderick.ici.location.service;

import com.hoderick.ici.location.dto.NearbyUserLocation;
import com.hoderick.ici.location.exception.UserNotFoundException;
import com.hoderick.ici.user.service.ProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private static final String GEO_KEY = "provider:locations";

    private final RedisTemplate<String, String> redisTemplate;
    private final ProviderService providerService;

    @Override
    public void updateLocation(UUID userId, double longitude, double latitude) {
        if (!providerService.isValidProvider(userId)) {
            throw new UserNotFoundException("The given User ID does not correlate to a registered provider.");
        }

        RedisGeoCommands.GeoLocation<String> location = new RedisGeoCommands.GeoLocation<>(
                userId.toString(),
                new Point(longitude, latitude)
        );
        log.debug("Updating location for user {}", userId);
        redisTemplate.opsForGeo().add(GEO_KEY, location);
    }

    @Override
    public List<NearbyUserLocation> findNearby(double longitude, double latitude, double radiusKm) {
        GeoResults<RedisGeoCommands.GeoLocation<String >> results = getNearbyResults(longitude, latitude, radiusKm);

        return results.getContent().stream()
                .map(result -> {
                    RedisGeoCommands.GeoLocation<String> location = result.getContent();
                    Point point = location.getPoint();
                    double distKm = result.getDistance().getValue();
                    return new NearbyUserLocation(location.getName(), point.getX(), point.getY(), distKm);
                })
                .toList();
    }

    private GeoResults<RedisGeoCommands.GeoLocation<String>> getNearbyResults(double longitude,
                                                                              double latitude,
                                                                              double radiusKm) {
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs()
                .includeCoordinates()
                .includeDistance()
                .sortAscending();

        Distance distance = new Distance(radiusKm, Metrics.KILOMETERS);
        Point centre = new Point(longitude, latitude);
        Circle circle = new Circle(centre, distance);

        return redisTemplate
                .opsForGeo()
                .radius(GEO_KEY, circle, args);
    }
}
