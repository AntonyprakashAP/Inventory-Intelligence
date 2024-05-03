package com.algoriant.site.entity;

import com.algoriant.site.dto.FloorRequest;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;


@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @Column(columnDefinition = "uuid", name = "floor_id")
    private UUID floorId;


    @Column(name = "site_id")
    private UUID siteId;

    @Column(name = "floor_name")
    private String floorName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;



    public Floor(UUID floorId, UUID siteId, String floorName, String description, Timestamp createdAt, Timestamp updatedAt) {
        this.floorId = floorId;
        this.siteId = siteId;
        this.floorName = floorName;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Floor() {
    }


    public UUID getFloorId() {
        return floorId;
    }

    public void setFloorId(UUID floorId) {
        this.floorId = floorId;
    }

    public UUID getSiteId() {
        return siteId;
    }

    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
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


    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public static Floor toEntity(FloorRequest floorRequest) {
        Floor floor = new Floor();
        floor.setSiteId(floorRequest.getSiteId());
        floor.setFloorName(floorRequest.getFloorName());
        floor.setDescription(floorRequest.getDescription());
        return floor;
    }

}
