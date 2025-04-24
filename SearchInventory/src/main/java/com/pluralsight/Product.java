package com.pluralsight;

public class Product {
    private int skuNum = 0;
    private  String itemName = "";
    private float price = 0;

    public Product(int skuNum, String itemName, float price) {
        this.skuNum = skuNum;
        this.itemName = itemName;
        this.price = price;
    }

    public int getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(int skuNum) {
        this.skuNum = skuNum;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }




}
