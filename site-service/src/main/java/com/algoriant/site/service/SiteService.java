package com.algoriant.site.service;

import com.algoriant.site.dto.SiteRequest;
import com.algoriant.site.entity.Site;
import com.algoriant.site.entity.Zone;
import com.algoriant.site.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SiteService {

    @Autowired
    private SiteRepository repository;

    public Site createSite(SiteRequest siteRequest) {
        repository.insertSite(siteRequest.getSiteName(), siteRequest.getLocation());
        return Site.toEntity(siteRequest);
    }

    public  List<Site> getAllSite(){
        return repository.getAllSite();
    }

    public Site getSiteById(UUID siteId) {
        return repository.getSiteById(siteId);
    }

    public void deleteBySiteId(UUID siteId) {
        repository.deleteSiteById(siteId);
    }
    public Site updateSite(UUID siteId,SiteRequest request) {
        Site site = Site.toEntity(request);
        site.setSiteId(siteId);
        repository.updateSite(siteId, request.getSiteName(), request.getLocation());
        return site;
    }
}
