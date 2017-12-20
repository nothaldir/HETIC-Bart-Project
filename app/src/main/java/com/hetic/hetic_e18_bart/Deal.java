package com.hetic.hetic_e18_bart;

/**
 * Created by Whorthy on 20/12/2017.
 */

public class Deal {

    String dealId;
    String dealTitre;
    int dealPrix;
    String dealDescription;

    public Deal(){

    }

    public Deal(String dealId, String dealTitre, int dealPrix, String dealDescription) {
        this.dealId = dealId;
        this.dealTitre = dealTitre;
        this.dealPrix = dealPrix;
        this.dealDescription = dealDescription;
    }

    public String getDealId() {
        return dealId;
    }

    public String getDealTitre() {
        return dealTitre;
    }

    public int getDealPrix() {
        return dealPrix;
    }

    public String getDealDescription() {
        return dealDescription;
    }
}
