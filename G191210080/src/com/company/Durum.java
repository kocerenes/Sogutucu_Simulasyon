package com.company;

public class Durum{

    public static int mSaniye=2000;

    // cihazın bekleme özelliği için metod
    //ne kadar bekleneceğini kendimizin seçtiği durumlar için
    public static void bekle(int sure)
    {
        try {
            Thread.sleep(sure);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //cihazın kapanma özelliği için metod
    public static void kapalı()
    {
        try {
            System.out.println("Cihaz kapanıyor...");
            Thread.sleep(mSaniye);
            System.out.println("Cihaz kapalı duruma geçti.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // cihazın algılama özelliği için metod
    public static void algıla()
    {
        try {
            System.out.println("Sıcaklık algılanıyor...");
            Thread.sleep(mSaniye);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //cihazın servis dışı oldugu durumlar için metod
    public static void servisDisi()
    {
        System.out.println("Sistem servis dışı.");
    }

    //cihazın işlem yaptığı anlar için metod
    public static void islemYap()
    {
        try {
            System.out.println("İşlem yapılıyor...");
            Thread.sleep(mSaniye);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
