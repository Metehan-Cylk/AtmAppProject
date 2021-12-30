/*package com.testinium.odev2.utilities;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.sql.SQLException;
import java.util.Date;
public class PerformanceTest {
    MiktarCikar cikar ;
    MiktarEkle ekle;
    ParaTransfer transfer;

    // Her test methoduna girmeden önce setUp methoduna girecek ve sınıfın örneğini oluşturacak.
    @Before
    public void setUp() throws SQLException {
        cikar= new MiktarCikar();
        ekle = new MiktarEkle();
        transfer = new ParaTransfer();
        
    }
    @Test
    public void paraEkle() {
   
    	Long start = System.currentTimeMillis();
    	for(double i = 0 ; i < 1000000 ; i++) {
    		ekle.miktarEkle(20, 30);
    	}
        
        Long end = System.currentTimeMillis();
        System.out.println("MiktarEkle modülü 1000000 çalışmasıyla " + (end - start) + " milisaniye sürmektedir.");
    }
    @Test
    public void paraCikar() {

    	Long start = System.currentTimeMillis();
    	for(double i = 0 ; i < 1000000 ; i++) {
    		cikar.miktarCikar(10,30);
    	}
        
        Long end = System.currentTimeMillis();
        System.out.println("MiktarCikar modülü 1000000 çalışmasıyla " + (end - start) + " milisaniye sürmektedir.");
    }
    @Test
    public void paraTransfer() {
    	Customer from = new IndividualCustomer("234234242","ali",2342,"adres");
    	Customer to = new IndividualCustomer("234234242","ali",2342,"adres");
    	Long start = System.currentTimeMillis();
    	for(double i = 0 ; i < 1000000 ; i++) {
    		transfer.ParaTransfer(from, to, 0);
    	}
        
        Long end = System.currentTimeMillis();
        System.out.println("ParaTransfer modülü 1000000 çalışmasıyla " + (end - start) + " milisaniye sürmektedir.");
    }
   
    @After
    public void tearDown() {
        cikar = null;
        ekle = null;
        transfer = null;
    }
}
*/