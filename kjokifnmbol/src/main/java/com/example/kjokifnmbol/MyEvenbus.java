package com.example.kjokifnmbol;

import java.io.Serializable;

public class MyEvenbus implements Serializable {
    private int max;
    private int pass;
    private int zong;

    public MyEvenbus(int max, int pass, int zong) {
        this.max = max;
        this.pass = pass;
        this.zong = zong;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getZong() {
        return zong;
    }

    public void setZong(int zong) {
        this.zong = zong;
    }

    @Override
    public String toString() {
        return "MyEvenbus{" +
                "max=" + max +
                ", pass=" + pass +
                ", zong=" + zong +
                '}';
    }
}

