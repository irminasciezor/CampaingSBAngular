package com.example.Campaign.config.controller;
import com.example.Campaign.config.entity.Campaign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.example.Campaign.config.repository.CampaignRepository;
import com.example.Campaign.config.service.CampaignServiceImpl;

import java.util.*;

@Controller
public class CampaignController {

    private final CampaignRepository campaignRepository;

    private final List<String> townList = Arrays.asList("Cracow","Amsterdam","New York", "Tokio");


    @Autowired
    private CampaignServiceImpl service;
    private Logger logger = LoggerFactory.getLogger(CampaignController.class);


    public CampaignController(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @GetMapping("/campaign")
    public String getCampaign(Campaign campaign, Model model){

        model.addAttribute("towns", townList);
        return "campaign";
    }

    @PostMapping("/campaign")
    public String postCampaign(Campaign newCampaign, Model model){
        Campaign campaign = service.save(newCampaign);
        model.addAttribute("status", campaign.isStatus());
        return "campaign";
    }

    @GetMapping("/index")
    public String getCampaign(Model model){
        Campaign campaign = new Campaign();
        model.addAttribute("campaigns", service.findAll());
        model.addAttribute("campaign", campaign);
        return "index";

    }

    @GetMapping("/delete/{id}")
    public String deleteCampaign(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawMoney(@PathVariable("id") Long id, Model model){
        Campaign campaign = service.findById(id);
        model.addAttribute("campaign", campaign);
        return "withdraw";
    }

    @PostMapping("/withdraw/{id}")
    public String updatedBidAmount(@PathVariable("id")Long id, @ModelAttribute(value = "number") String number,
                                   BindingResult result){
        logger.info("ID" + id);
        logger.info("Number" + number);
        Campaign campaign = service.findById(id);
        if ((campaign.getBidAmount()-Double.parseDouble(number))<0)
            result.addError(new ObjectError("badWithdraw", "less than 0"));
        if (result.hasErrors()){
            return "redirect:/withdraw/" + id ;
        }
        campaign.setBidAmount(campaign.getBidAmount()-Double.parseDouble(number));
        service.save(campaign);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String updateCampaign(@PathVariable("id") String id, Model model){
        logger.info("ID: "+id);
        Campaign campaign = service.findById(Long.valueOf(id));
        model.addAttribute("campaign", campaign);
        model.addAttribute("towns", townList);

        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String saveUpdateCampaign(Campaign campaign, @PathVariable("id") String id){
        service.save(campaign);
        return "redirect:/index";
    }


}
