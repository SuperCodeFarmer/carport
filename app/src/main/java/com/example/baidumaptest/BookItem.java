package com.example.baidumaptest;

/**
 * Created by yly on 2018/12/14.
 */

public class BookItem {
    private int carportImage;
    private String carportAddress;
    private String carportCost;
    private String carportTimeout;

    public BookItem(int carportImage, String carportAddress, String carportCost, String carportTimeout) {
        this.carportImage = carportImage;
        this.carportAddress = carportAddress;
        this.carportCost = carportCost;
        this.carportTimeout = carportTimeout;
    }

    public void setCarportImage(int carportImage) {
        this.carportImage = carportImage;
    }

    public void setCarportAddress(String carportAddress) {
        this.carportAddress = carportAddress;
    }

    public void setCarportCost(String carportCost) {
        this.carportCost = carportCost;
    }

    public void setCarportTimeout(String carportTimeout) {
        this.carportTimeout = carportTimeout;
    }

    public int getCarportImage() {
        return carportImage;
    }

    public String getCarportAddress() {
        return carportAddress;
    }

    public String getCarportCost() {
        return carportCost;
    }

    public String getCarportTimeout() {
        return carportTimeout;
    }
}
