package com.company;

import org.postgresql.util.PGTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{

    private int sicaklik;

    //anlık tarihi alıp string türüne çevirdiğim kısım
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = dateTime.format(timeFormatter);

    public int getSicaklik() {
        Random random = new Random();
        sicaklik = random.nextInt(65);
        Durum.algıla();
        DatabaseHelper.SicaklikDal.Insert(sicaklik,formattedDate);
        return sicaklik;
    }

}
