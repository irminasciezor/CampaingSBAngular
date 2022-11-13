package com.example.Campaign.config.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Campaign {
    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String name;
    @Column
    private String keywords;
    @Column
    private double bidAmount;
    @Column
    private double campaignFund;
    @Column
    private boolean status;
    @Column
    private String town;
    @Column
    private double radius;

    public Campaign(Long id, String name, String keywords, double bidAmount, double campaignFund, boolean status, String town, double radius) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public Campaign() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public double getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(double campaignFund) {
        this.campaignFund = campaignFund;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", bidAmount=" + bidAmount +
                ", campaignFund=" + campaignFund +
                ", status=" + status +
                ", town='" + town + '\'' +
                ", radius=" + radius +
                '}';
    }
}
