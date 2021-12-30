package com.testinium.odev2.utilities;

public class ParaTransfer {
    public void ParaTransfer(Customer from, Customer to, int miktar){
    	MiktarCikar miktarCikar = new MiktarCikar();
    	MiktarEkle miktarEkle = new MiktarEkle();
    	
        from.setBakiyeBilgi(miktarCikar.miktarCikar(miktar, from.getBakiyeBilgi()));
        to.setBakiyeBilgi(miktarEkle.miktarEkle(miktar, to.getBakiyeBilgi()));
    }
}
