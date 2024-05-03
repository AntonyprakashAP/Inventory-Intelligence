package com.algoriant.site.dto;

import com.algoriant.site.entity.Zone;

import java.util.UUID;

public class ZoneRequest {

    private String zoneName;
    private String description;
    private UUID floorId;

    public UUID getFloorId() {
        return floorId;
    }

    public void setFloorId(UUID floorId) {
        this.floorId = floorId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
