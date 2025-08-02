package com.halalradar.api.dtos;

import com.halalradar.api.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private Long id;
    private Location location;
    private String name;
    private String mainImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocationDto locationDto;


}
