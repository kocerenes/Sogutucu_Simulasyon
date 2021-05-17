package com.company;

import java.util.Scanner;

public class Klavye implements IKlavye{


    Scanner scanner=null;
    String string;
    int anInt;

    public Klavye(){
        scanner = new Scanner(System.in);
    }

    public Klavye(Builder builder) {
        this.scanner = new Scanner(System.in);
        this.string = builder.string;
        this.anInt = builder.anInt;
    }


    public Scanner getScanner() {
        return scanner;
    }

    public String getKlavye() {
        return string;
    }

    public void setKlavye(String string) {
        this.string = string;
    }

    public int getSifre() {
        return anInt;
    }

    public void setSifre(int anInt) {
        this.anInt = anInt;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static class Builder{

        private String string;
        int anInt;

        public Builder(){ }

        public Builder name(String string){
            this.string = string;
            return this;
        }

        public Builder surname(int anInt){
            this.anInt = anInt;
            return this;
        }

        public Klavye build(){
            return new Klavye(this);
        }

    }

    @Override
    public int intVeriAl() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public String stringVeriAl() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
