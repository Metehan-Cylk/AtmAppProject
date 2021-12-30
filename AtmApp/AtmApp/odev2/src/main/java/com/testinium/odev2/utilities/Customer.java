package com.testinium.odev2.utilities;

public abstract class Customer {
    private String tcNo;
    private String adSoyad;
    private int bakiyeBilgi;





    public Customer(String tcNo, String adSoyad, int bakiyeBilgi) {
        this.tcNo=tcNo;
        this.adSoyad=adSoyad;
        this.bakiyeBilgi=bakiyeBilgi;

    }

    public String getTcNo() {
        return tcNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }


    public int getBakiyeBilgi() {
        return bakiyeBilgi;
    }

    public void setBakiyeBilgi(int bakiyeBilgi) {
        this.bakiyeBilgi = bakiyeBilgi;
    }

    public abstract String getAdres();


}
