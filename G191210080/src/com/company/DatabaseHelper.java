package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DatabaseHelper {

    //veritabanına bağlantı sağlamak için metod
    public static Connection CreateConnection()
    {
        final String dbUrl = "jdbc:postgresql://localhost:5432/dbSogutucu";
        final String userName = "postgres";
        final String password = "24042000";

        java.sql.Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl,userName,password);
            //System.out.println("Veritabanına başarılı şekilde bağlanıldı.");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return  connection;
    }


    // Kullanıcılar için Create read işlemleri
    public static class KullaniciDal{

        //Veritabanına kullanıcı eklemek için metod
        public static void Insert()
        {
            Connection connection = CreateConnection();

            try {
                String kullaniciAd,sifre;

                Scanner scanner = new Scanner(System.in);

                String sqlInsert = "INSERT INTO tblkullanici (kullaniciad,sifre) values (?,?)"; //kullanıcı ekleme işlemim için sql sorgum
                PreparedStatement preparedStatement=connection.prepareStatement(sqlInsert);

                // kullanıcının kullanıcı adını ekledim
                System.out.print("Kullanıcı ad giriniz: ");
                kullaniciAd = scanner.next();
                preparedStatement.setString(1, kullaniciAd);

                // kullanıcının şifresini ekledim
                System.out.print("Şifre giriniz: ");
                sifre = scanner.next();
                preparedStatement.setString(2, sifre);

                preparedStatement.executeUpdate(); //değişiklikleri kaydettim
                preparedStatement.close();
                connection.close();

                System.out.println("Kayıt eklendi.");
            } catch (SQLException exception) {
                System.out.println("Kayıt eklenemedi.");
                //exception.printStackTrace();
            }
        }

        //Veritabanındaki kullanıcıları listelemek için static metod
        public static void Select()
        {
            Connection connection =CreateConnection();

            Statement statement;
            ResultSet resultSet;

            try {

                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT id, kullaniciad FROM tblkullanici");

                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    String kullaniciAd = resultSet.getString("kullaniciad");
                    //String sifre = resultSet.getString("sifre");

                    System.out.println("ID : "+id + "        " + "Kullanıcı Ad : "+kullaniciAd);
                }
                resultSet.close();
                connection.close();

            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }

        // kullanıcının giriş bilgilerini doğrulamak için metod
        public static boolean Login(String kullaniciAd, String sifre)
        {
            Connection connection = CreateConnection();
            String loginSql = "SELECT *  FROM \"tblkullanici\" WHERE \"kullaniciad\"='"+ kullaniciAd+"' AND sifre= '"+ sifre+"'";

            if (connection != null)
            {

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(loginSql);
                    connection.close();

                    if (resultSet.next())
                    {
                        System.out.println("giriş başarılı.");
                        return true;
                    }
                    else {
                        System.out.println("Hatalı giriş.");
                        return false;
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }


            }else {
                return false;
            }
            return false;
        }

    }

    // ölçülen sıcaklık verilerini veritabanında tutmak için metod
    public static class SicaklikDal
    {
        //ölçülen sıcaklıgı veritabanına ekleme metodu
        public static void Insert(int sicaklik, String tarih)
        {
            Connection connection = CreateConnection();

            try {

                String sqlInsert = "INSERT INTO tblsicaklik (sicaklik,tarih) values (?,?)"; //kullanıcı ekleme işlemim için sql sorgum
                PreparedStatement preparedStatement=connection.prepareStatement(sqlInsert);

                // ölçülen sıcaklık verisini ekledim
                preparedStatement.setInt(1, sicaklik);

                // kullanıcının şifresini ekledim
                preparedStatement.setString(2, tarih);

                preparedStatement.executeUpdate(); //değişiklikleri kaydettim
                preparedStatement.close();
                connection.close();

                System.out.println("Güncel sıcaklık veriniz kayıt edildi.");
            } catch (SQLException exception) {
                System.out.println("Kayıt eklenemedi.");
                //exception.printStackTrace();
            }
        }

        //sıcaklık verilerini ekrana getirme metodu
        public static void Select()
        {
            Connection connection =CreateConnection();

            Statement statement;
            ResultSet resultSet;

            try {

                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT id, sicaklik,tarih FROM tblsicaklik");

                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    int sicaklik = resultSet.getInt("sicaklik");
                    String tarih = resultSet.getString("tarih");

                    System.out.println("ID : "+id + "        " + "Sıcaklık : "+sicaklik + "        " + "tarih : "+tarih);
                }
                resultSet.close();
                connection.close();

            } catch (SQLException exception) {
                exception.printStackTrace();
            }

        }

    }



}
