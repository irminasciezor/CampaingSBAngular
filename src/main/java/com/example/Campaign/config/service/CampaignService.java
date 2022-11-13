package com.example.Campaign.config.service;

import com.example.Campaign.config.entity.Campaign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CampaignService {

List<Campaign> findAll();

Campaign save(Campaign campaign);

void deleteById(Long id);

Campaign findById(Long id);

void withdraw(Long id);

}
