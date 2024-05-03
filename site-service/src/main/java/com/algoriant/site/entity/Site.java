package com.algoriant.site.entity;

import com.algoriant.site.dto.SiteRequest;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;



@Entity
@Table(name = "site")
public class Site {

    @Id
    @Column(columnDefinition = "uuid", name = "site_id")
    private UUID siteId;
    @Column(name = "site_name")
    private String siteName;
    @Column(name = "location")
    private String location;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;


    public Site(UUID siteId, String siteName, String location, Timestamp createdAt, Timestamp updatedAt) {
        this.siteId = siteId;
        this.siteName = siteName;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Site() {
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


    public UUID getSiteId() {
        return siteId;
    }

    public void setSiteId(UUID siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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



    @Override
    public String toString() {
        return "Site{" +
                "siteId=" + siteId +
                ", siteName='" + siteName + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static Site toEntity(SiteRequest request) {
        Site site = new Site();
        site.setSiteName(request.getSiteName());
        site.setLocation(request.getLocation());
        return site;
    }
}



