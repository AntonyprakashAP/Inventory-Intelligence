package com.algoriant.site.controller;

import com.algoriant.site.dto.SiteRequest;
import com.algoriant.site.entity.Site;
import com.algoriant.site.entity.Zone;
import com.algoriant.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/site-service")
@PreAuthorize("hasAnyAuthority('CUSTOMER_ADMIN')")
public class SiteController {

    @Autowired
    private SiteService service;

    @PostMapping("/createSite")
    public ResponseEntity<Site> createSite(@RequestBody SiteRequest request) {
        Site site = service.createSite(request);
        return new ResponseEntity<>(site,HttpStatus.CREATED);
    }

    @GetMapping("/getAllSite")
    public ResponseEntity<List<Site>> getAllSite() {
        return new ResponseEntity<>(service.getAllSite(),HttpStatus.OK);
    }

    @GetMapping("/getSiteById/{siteId}")
    public ResponseEntity<Site> getSiteById(@PathVariable("siteId") UUID siteId) {
        return new ResponseEntity<>(service.getSiteById(siteId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{siteId}")
    public ResponseEntity<String> deleteSiteById(@PathVariable("siteId") UUID siteId) {
        service.deleteBySiteId(siteId);
        return new ResponseEntity<>("delete successfully", HttpStatus.OK);
    }

    @PutMapping("/updateSiteById/{siteId}")
    public ResponseEntity<Site> updateSite(@PathVariable("siteId") UUID siteId, @RequestBody SiteRequest request) {
        Site site = service.updateSite(siteId,request);
        return new ResponseEntity<>(site,HttpStatus.OK);
    }
}
