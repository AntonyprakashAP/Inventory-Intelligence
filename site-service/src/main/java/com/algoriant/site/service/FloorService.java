package com.algoriant.site.service;

import com.algoriant.site.dto.FloorRequest;
import com.algoriant.site.entity.Floor;
import com.algoriant.site.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FloorService {

    @Autowired
    private FloorRepository repository;

    public Floor createFloor(FloorRequest request) {
        repository.insertFloor(request.getSiteId(),request.getFloorName(), request.getDescription());
        return Floor.toEntity(request);
    }

    public List<Floor> getAllFloor() {
        return repository.getAllFloor();
    }

    public Floor getFloorById(UUID floorId) {
        return repository.getFloorById(floorId);
    }

    public void deleteFloorById(UUID floorId) {
        repository.deleteFloorById(floorId);
    }

    public Floor updateFloor(UUID floorId, FloorRequest floorRequest) {
        Floor floor = Floor.toEntity(floorRequest);
        floor.setFloorId(floorId);
        repository.updateFloor(floorId, floor.getSiteId(), floor.getFloorName(), floor.getDescription());
        return floor;
    }

}
