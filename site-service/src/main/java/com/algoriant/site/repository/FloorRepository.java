package com.algoriant.site.repository;

import com.algoriant.site.entity.Floor;
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
public interface FloorRepository extends JpaRepository<Floor, UUID> {

    @Modifying
    @Query(value = "INSERT INTO floor(site_id, floor_name, description, created_at, updated_at) VALUES(:siteId, :floorName, :description, now(),now())",nativeQuery = true)
    void insertFloor(@Param("siteId") UUID siteId,@Param("floorName") String floorName, @Param("description") String description);

    @Query(value = "SELECT * FROM floor",nativeQuery = true)
    List<Floor> getAllFloor();

    @Query(value = "SELECT * FROM floor WHERE floor.floor_id = :floorId", nativeQuery = true)
    Floor getFloorById(@Param("floorId") UUID floorId);

    @Modifying
    @Query(value = "DELETE FROM floor WHERE floor.floor_id = :floorId", nativeQuery = true)
    void deleteFloorById(@Param("floorId") UUID floorId);

    @Modifying
    @Query(value = "UPDATE floor SET site_id = :siteId, floor_name = :floorName, description = :description,updated_at = now() WHERE floor_id = :floorId ", nativeQuery = true)
    void updateFloor(@Param("floorId") UUID floorId,@Param("siteId") UUID siteId, @Param("floorName") String floorName, @Param("description") String description);
}
