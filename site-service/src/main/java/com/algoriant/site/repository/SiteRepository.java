package com.algoriant.site.repository;

import com.algoriant.site.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional

@Repository
public interface SiteRepository extends JpaRepository<Site, UUID> {

    @Modifying
    @Query(value = "INSERT INTO site(site_name, location,created_at,updated_at) VALUES(:siteName, :location, now(), now())", nativeQuery = true)
    void insertSite(@Param("siteName") String siteName, @Param("location") String location);

    @Query(value = "SELECT * FROM site", nativeQuery = true)
    List<Site> getAllSite();

    @Query(value = "SELECT * FROM site  WHERE site.site_id = :siteId", nativeQuery = true)
    Site getSiteById(@Param("siteId") UUID siteId);

    @Modifying
    @Query(value = "DELETE FROM site  WHERE site.site_id = :siteId", nativeQuery = true)
    void deleteSiteById(@Param("siteId") UUID siteId);

    @Modifying
    @Query(value = "UPDATE site SET site_name = :siteName, location = :location, updated_at = now() WHERE site_id = :siteId", nativeQuery = true)
    void updateSite(@Param("siteId") UUID siteId, @Param("siteName") String siteName, @Param("location") String location);

}
