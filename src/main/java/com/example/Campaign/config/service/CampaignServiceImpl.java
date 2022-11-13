package com.example.Campaign.config.service;

import com.example.Campaign.config.entity.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Campaign.config.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService{

    @Autowired
    private CampaignRepository campaignRepository;


    @Override
    public List<Campaign> findAll() {
        return (List<Campaign>) campaignRepository.findAll();
    }

    @Override
    public Campaign save(Campaign campaign) {
        campaignRepository.save(campaign);
        return campaign;
    }

    @Override
    public void deleteById(Long id) {
        campaignRepository.deleteById(id);
    }

    @Override
    public Campaign findById(Long id) {
        return campaignRepository.findById(id).get();
    }

    @Override
    public void withdraw(Long id) {

    }
}
