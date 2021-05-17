package com.company;

import java.util.Random;

public class Eyleyici implements IEyleyici{

    Random random = new Random();

    @Override
    public void SogutucuAc() {
        System.out.println("Soğutucu açılıyor..");
        Durum.bekle(1200);
        System.out.println("Soğutucu açıldı.");
    }

    @Override
    public void SogutucuKapat() {
        System.out.println("Soğutucu kapatılıyor..");
        Durum.bekle(1200);
        System.out.println("Soğutucu kapatıldı.");
    }
}
