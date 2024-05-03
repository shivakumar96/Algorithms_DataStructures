package com.shivakumar.algorithms.parctice.design.patterns;

public class Singleton {

    private static Singleton ele;

    private Singleton(){

    }

    public static Singleton getInstance(){
        return  ele==null? ele= new Singleton(): ele;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
