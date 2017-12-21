package com.hetic.hetic_e18_bart;

/**
 * Created by Whorthy on 20/12/2017.
 */

public class Deal {

    String deal_id;
    String deal_name;
    int deal_price;
    String deal_description;

    public Deal(){

    }

    public Deal(String deal_id, String deal_name, int deal_price, String deal_description) {
        this.deal_id = deal_id;
        this.deal_name = deal_name;
        this.deal_price = deal_price;
        this.deal_description = deal_description;
    }

    public String getDealId() {
        return deal_id;
    }

    public String getDealTitre() {
        return deal_name;
    }

    public int getDealPrix() {
        return deal_price;
    }

    public String getDealDescription() {
        return deal_description;
    }
}
