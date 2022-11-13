package com.example.Campaign.config.controller;
import com.example.Campaign.config.entity.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Campaign.config.repository.CampaignRepository;
import com.example.Campaign.config.service.CampaignServiceImpl;

import java.util.*;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
public class CampaignController {

    private final CampaignRepository campaignRepository;


    @Autowired
    private CampaignServiceImpl service;
    private Logger logger = LoggerFactory.getLogger(CampaignController.class);


    public CampaignController(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @PostMapping("/campaign")
    @ResponseBody
    public ResponseEntity<Campaign> postCampaign(Campaign newCampaign){
        Campaign campaign = service.save(newCampaign);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }

    @GetMapping("/campaign")
    @ResponseBody
    public ResponseEntity<List<Campaign>> getCampaign(){
        List<Campaign> campaignList = service.findAll();
        return new ResponseEntity<>(campaignList, HttpStatus.OK);

    }

    @GetMapping("/delete")
    public void deleteCampaign(Long id){
        campaignRepository.deleteById(id);
    }

    @GetMapping("/edit")
    public ResponseEntity<String> updateCampaign(Campaign campaign){
        service.save(campaign);
        return new ResponseEntity<>("success", HttpStatus.OK);

    }



}
