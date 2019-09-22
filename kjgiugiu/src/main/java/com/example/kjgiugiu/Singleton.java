package com.example.kjgiugiu;

public class Singleton {
    private Singleton() {
    }
/*
    public static DaoBean instance;

    public static DaoBean getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if(instance == null){
                    instance = new DaoBean();
                }
            }
        }
        return instance;
    }*/
}
