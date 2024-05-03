package com.algoriant.site.repository;

import com.algoriant.site.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Repository
public interface ZoneRepository extends JpaRepository<Zone, UUID> {

    @Modifying
    @Query(value = "INSERT INTO zone(floor_id,zone_name,description,created_at,updated_at) VALUES(:floorId,:zoneName, :description, now(),now())",nativeQuery = true)
    void insertZone(@Param("floorId") UUID floorId,@Param("zoneName") String zoneName, @Param("description") String description);
    @Query(value = "SELECT * FROM zone", nativeQuery = true)
    List<Zone> getAllZone();

    @Query(value = "SELECT * FROM zone WHERE zone.zone_id = :zoneId", nativeQuery = true)
    Zone getZoneById(@Param("zoneId") UUID zoneId);

    @Modifying
    @Query(value = "DELETE FROM zone WHERE zone.zone_id = :zoneId", nativeQuery = true)
    void deleteZoneById(@Param("zoneId") UUID zoneId);

    @Modifying
    @Query(value = "UPDATE zone SET floor_id= :floorId, zone_name = :zoneName, description = :description, updated_at = now() WHERE zone_id = :zoneId", nativeQuery = true)
    void updateZone( @Param("zoneId") UUID zoneId,@Param("floorId") UUID floorId,@Param("zoneName") String zoneName,@Param("description") String description);
}
