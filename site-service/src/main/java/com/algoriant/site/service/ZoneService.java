package com.algoriant.site.service;

import com.algoriant.site.dto.ZoneRequest;
import com.algoriant.site.entity.Zone;
import com.algoriant.site.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ZoneService {

   @Autowired
    private ZoneRepository repository;

   public Zone createZone(ZoneRequest request) {
       repository.insertZone(request.getFloorId(),request.getZoneName(), request.getDescription());
       return Zone.toEntity(request);
   }

   public List<Zone> getAllZone() {
       return repository.getAllZone();
   }

   public Zone getZoneById(UUID zoneId) {
       return repository.getZoneById(zoneId);
   }

   public void deleteZoneById(UUID zoneId) {
       repository.deleteZoneById(zoneId);
   }

   public Zone updateZone(UUID zoneId,UUID floorId,String zoneName, String description) {
       repository.updateZone(zoneId,floorId,zoneName,description);
       return null;
   }
}
