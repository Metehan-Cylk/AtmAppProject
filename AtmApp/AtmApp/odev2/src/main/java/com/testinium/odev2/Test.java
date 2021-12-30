package com.testinium.odev2;

import com.testinium.odev2.utilities.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("-----------Testinium java ödevi-----------");
        DbConnection db = new DbConnection();
        db.connect();
        Scanner scanner=new Scanner(System.in);


        /*Customer corporoteClient=new CorporoteClient("00000000000","Sedat Pekmez",10000,"Sirket1");
        Customer corporoteClient1=new CorporoteClient("00000000001","Miraç Beyaz",2000,"Sirket2");
        Customer corporoteClient2=new CorporoteClient("00000000002","Ali Boz",5000,"Sirket1");
        Customer corporoteClient3=new CorporoteClient("00000000003","Merve Aslan",3500,"Sirket2");
        Customer corporoteClient4=new CorporoteClient("00000000004","Hayati Güler",6000,"Sirket1");

        Customer individualCustomer=new IndividualCustomer("00000000005","Şamil Ağaç",340,"İstanbul");
        Customer individualCustomer1=new IndividualCustomer("00000000006","Kadir Kutlu",3250,"İstanbul");
        Customer individualCustomer2=new IndividualCustomer("00000000007","Furkan Zer",2100,"Eskişehir");
        Customer individualCustomer3=new IndividualCustomer("00000000008","Alperen Kozkan",4000,"Karabük");
        Customer individualCustomer4=new IndividualCustomer("00000000009","Sinan Kozalak",2500,"İstanbul");*/


        Map<String ,Customer > musteriMap =new HashMap<>();
        /*musteriMap.put("001",corporoteClient);
        musteriMap.put("002",individualCustomer2);
        musteriMap.put("003",corporoteClient2);
        musteriMap.put("004",individualCustomer);
        musteriMap.put("005",corporoteClient4);*/


        Boolean kontrol=true;

        String musteriNum;
        String karsiMusteriNum;
        do{
            Boolean kontrol1=true;
            scanner=new Scanner(System.in);
            System.out.println("Müşteri Numarasını giriniz/ Çıkmak için 0ı tuşlayınız");
            musteriNum=scanner.nextLine();
            if(musteriNum.equals("0")){
                kontrol=false;
                break;
            }
            Customer customer=musteriMap.get(musteriNum);
            if(customer!=null){

                System.out.println("Müşteri adı :"+customer.getAdSoyad());
                System.out.println("Tc nosu: "+customer.getTcNo());
                System.out.println("Bakiyesi: "+customer.getBakiyeBilgi());
                System.out.println("Kayıtlı adresi: "+customer.getAdres());

                while (kontrol1){
                    System.out.println("Para eklemek için 1'i, para eksiltmek için 2'yi, farklı bir müşteri için işlem yapmak istiyorsanız 3'ü,çıkmak için 4'ü tuşlayınız ");

                    int islem=scanner.nextInt();
                    switch (islem){
                        case 1:
                            System.out.println("Anlık bakiye bilgisi: " + musteriMap.get(musteriNum).getBakiyeBilgi());
                            System.out.println("Eklenecek Miktarı girin");
                            MiktarEkle miktarEkle = new MiktarEkle();
                            Integer eklenenMiktar = scanner.nextInt();
                            musteriMap.get(musteriNum).setBakiyeBilgi(miktarEkle.miktarEkle(eklenenMiktar, musteriMap.get(musteriNum).getBakiyeBilgi()));
                            System.out.println("Güncel bakiye bilgisi: " + musteriMap.get(musteriNum).getBakiyeBilgi());
                            break;

                        case 2:
                            System.out.println("Anlık bakiye bilgisi: " + musteriMap.get(musteriNum).getBakiyeBilgi());
                            System.out.println("Cikarilacak Miktarı girin");
                            MiktarCikar miktarCikar = new MiktarCikar();
                            Integer cikarilanMiktar = scanner.nextInt();
                            musteriMap.get(musteriNum).setBakiyeBilgi(miktarCikar.miktarCikar(cikarilanMiktar, musteriMap.get(musteriNum).getBakiyeBilgi()));
                            System.out.println("Güncel bakiye bilgisi: " + musteriMap.get(musteriNum).getBakiyeBilgi());
                            break;
                        case 3:
                        	Boolean kontrol3=false;
                        	scanner.nextLine();
                        	do {
	                        	System.out.println("Para gondermek istediginiz musteri numarasini giriniz / Islemi iptal etmek icin 0 giriniz");
	                        	
	                        	karsiMusteriNum=scanner.nextLine();
	                        	if(karsiMusteriNum.equals("0")) {
	                        		kontrol3=true;
	                        	}else {
	                        		Customer karsiCustomer=musteriMap.get(karsiMusteriNum);
	                        		if(karsiCustomer!=null) {
	                        			kontrol3=true;
	                        		}
	                        	}
	                        	
                        	}while(!kontrol3);
                        	Integer gonderilecekMiktar;
                        	do {
                        		kontrol3=true;
                        		System.out.println("Gondermek istediginiz miktari giriniz");
                            	gonderilecekMiktar = scanner.nextInt();
                            	if(gonderilecekMiktar > musteriMap.get(musteriNum).getBakiyeBilgi()) {
                            		System.out.println("Lutfen bakiyenizin yettigi bir miktar giriniz. Mevcut bakiyeniz : " + musteriMap.get(musteriNum).getBakiyeBilgi());
                            		kontrol3= false;
                            	}
                        	}while(!kontrol3);
                        	ParaTransfer paraTransfer = new ParaTransfer();
                        	paraTransfer.ParaTransfer(musteriMap.get(musteriNum),musteriMap.get(karsiMusteriNum),gonderilecekMiktar);
                        	
                            kontrol1=false;
                            break;


                        case 4:
                            kontrol1=false;
                            kontrol=false;
                            break;

                        default:
                            System.out.println("Hatalı tuşlama yaptınız. Lütfen tekrar deneyiniz!");
                            System.out.println("Para eklemek için 1'i, para eksiltmek için 2'yi, farklı bir müşteri için işlem yapmak istiyorsanız 3'ü,çıkmak için 4'ü tuşlayınız ");

                    }

                }

            }
            else{
                System.out.println("Müşteri bulunamadı, LÜTFEN TEKRAR DENEYİNİZ!");
            }



        }while (kontrol);



    }
}
