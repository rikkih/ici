package com.hoderick.ici.task.service.mapper;

import com.hoderick.ici.task.api.dto.request.LocationDto;
import com.hoderick.ici.task.domain.model.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toDto(Location location);
}
