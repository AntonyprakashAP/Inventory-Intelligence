package com.algoriant.site.entity;


import com.algoriant.site.dto.ZoneRequest;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Table(name = "zone")
@Entity
public class Zone {

    @Id
    @Column(columnDefinition = "uuid", name = "zone_id")
    private UUID zoneId;

    @Column(name = "floor_id", nullable = false)
    private UUID floorId;

    @Column(name = "zone_name")
    private String zoneName;
    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Zone(UUID zoneId, UUID floorId, String zoneName, String description, Timestamp createdAt, Timestamp updatedAt) {
        this.zoneId = zoneId;
        this.floorId = floorId;
        this.zoneName = zoneName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Zone() {
    }

    public UUID getZoneId() {
        return zoneId;
    }

    public void setZoneId(UUID zoneId) {
        this.zoneId = zoneId;
    }

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }


    public static Zone toEntity(ZoneRequest request) {
        Zone zone = new Zone();
        zone.setZoneName(request.getZoneName());
        zone.setDescription(request.getDescription());
        zone.setFloorId(request.getFloorId());
        return zone;
    }

}
