package com.testinium.odev2.utilities;

public class IndividualCustomer extends Customer{
    private String evAdresi;

    public IndividualCustomer(String tcNo, String adSoyad, int bakiyeBilgi, String evAdresi) {
        super(tcNo, adSoyad, bakiyeBilgi);
        this.evAdresi = evAdresi;
    }



    @Override
    public String getAdres() {
        return evAdresi;
    }
}
