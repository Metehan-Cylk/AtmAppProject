package com.testinium.odev2.utilities;

public class CorporoteClient extends Customer{
    private String sirketAdi;

    public CorporoteClient(String tcNo, String adSoyad, int bakiyeBilgi, String sirketAdi) {
        super(tcNo, adSoyad, bakiyeBilgi);
        this.sirketAdi = sirketAdi;
    }



    @Override
    public String getAdres() {
        return sirketAdi;
    }
}
