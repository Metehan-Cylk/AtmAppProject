package com.testinium.odev2.utilities;

public class MiktarCikar{
    public int miktarCikar(int x, int y){
        if(x>y){
            System.out.println("Yetersiz Bakiye");
            return y;
        }
        else
            return y-x;
    }
}
