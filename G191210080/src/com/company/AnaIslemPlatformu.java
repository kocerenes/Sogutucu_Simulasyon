package com.company;

import java.util.Scanner;

public class AnaIslemPlatformu {

    private final static int Sicaklik_Olc = 1;
    private final static int Sogutucu_Ac = 2;
    private final static int Sogutucu_Kapat = 3;
    private final static int Kullanici_Ekle = 4;
    private final static int Kullanici_Liste = 5;
    private final static int Sicaklik_Liste = 6;
    private final static int Cikis = 7;

    private IEkran ekran;
    private IKlavye klavye;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;

    public AnaIslemPlatformu()
    {
        ekran = new Ekran();
        klavye = new Klavye();
        sicaklikAlgilayici = new SicaklikAlgilayici();
        eyleyici = new Eyleyici();
    }

    public void basla()
    {
        String kullaniciad,sifre;
        boolean girisDogrulama;

        System.out.print("Kullanıcı adı : ");
        kullaniciad = klavye.stringVeriAl();
        System.out.print("Şifre : ");
        sifre = klavye.stringVeriAl();

        girisDogrulama = DatabaseHelper.KullaniciDal.Login(kullaniciad,sifre);

        if (girisDogrulama == true)
        {
            IslemSec();
        }
    }


    private int MenuGetir()
    {
        //ekran.EkranTemizle();
        ekran.MesajGoruntule("1- Sıcaklığı ölç.");
        ekran.MesajGoruntule("2- Soğutucu aç.");
        ekran.MesajGoruntule("3- Soğutucu kapat.");
        ekran.MesajGoruntule("4- Kullanıcı ekle.");
        ekran.MesajGoruntule("5- Kullanıcıları görüntüle.");
        ekran.MesajGoruntule("6- Geçmiş sıcaklık verilerini görüntüle.");
        ekran.MesajGoruntule("7- Çıkış yap.");
        System.out.print("Seçim : ");
        return klavye.intVeriAl();

    }


    private void IslemSec()
    {
        int secim;
        do {
            System.out.println("\n");
            secim = MenuGetir();
            System.out.println("\n");

            switch (secim)
            {
                case Sicaklik_Olc:
                    System.out.println(sicaklikAlgilayici.getSicaklik());
                    break;
                case Sogutucu_Ac:
                    eyleyici.SogutucuAc();
                    break;
                case Sogutucu_Kapat:
                    eyleyici.SogutucuKapat();
                    break;
                case Kullanici_Ekle:
                    DatabaseHelper.KullaniciDal.Insert();
                    break;
                case Kullanici_Liste:
                    DatabaseHelper.KullaniciDal.Select();
                    break;
                case Sicaklik_Liste:
                    DatabaseHelper.SicaklikDal.Select();
                    break;
                case Cikis:
                    Durum.kapalı();
                    break;
                default:
                    System.out.println("Geçerli bir işlem seçiniz.");
                    break;
            }

        }while (secim!=7);

        //observer
        if(secim>7){
            System.out.println("lütfen 8 den küçük bir sayı giriniz.");
        }
    }


}
