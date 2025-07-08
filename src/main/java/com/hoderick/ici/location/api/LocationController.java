package com.hoderick.ici.location.api;

import com.hoderick.ici.location.api.dto.UpdateLocationRequest;
import com.hoderick.ici.location.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<Void> updateLocation(@RequestBody UpdateLocationRequest request) {
        locationService.updateLocation(request.userId(), request.longitude(), request.latitude());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
