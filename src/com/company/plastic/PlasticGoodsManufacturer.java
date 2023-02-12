package com.company.plastic;

import com.company.plastic.PlasticGoods;

import java.util.*;

public class PlasticGoodsManufacturer {
    private String name;
    private Set<PlasticGoods> plasticGoods;

    public PlasticGoodsManufacturer(String name) {
        this.name = name;
        this.plasticGoods = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<PlasticGoods> getPlasticGoods() {
        return plasticGoods;
    }


    public double averagePrice(){
        double averagePrice = 0;
        for (PlasticGoods plasticItem: plasticGoods) {
            averagePrice += plasticItem.getPrice();
        }
        return averagePrice/ plasticGoods.size();
    }

    public PlasticGoods getPlasticItemWithAveragePrice(){

        Map<Double,PlasticGoods> plasticGoodsDoubleMap = new TreeMap<>();
        PlasticGoods plasticItemAVR = new PlasticGoods() ;
        for (PlasticGoods plasticItem: plasticGoods) {
            plasticGoodsDoubleMap.put(Math.abs(plasticItem.getPrice()-averagePrice()),plasticItem);

        }
        return plasticGoodsDoubleMap.get(Collections.min(plasticGoodsDoubleMap.keySet()));
    }

    public Set<PlasticGoods> getGoodsWithGreaterPriceThanAVR(){
        Set<PlasticGoods> plasticGoodsAboveAVRPrice = new HashSet<>();
        for (PlasticGoods plasticItem: plasticGoods) {
            if(plasticItem.getPrice() > averagePrice())
                plasticGoodsAboveAVRPrice.add(plasticItem);
        }
        return plasticGoodsAboveAVRPrice;
    }
    public Set<PlasticGoods> getGoodsWithSmallerPriceThanAVR(){
        Set<PlasticGoods> plasticGoodsAboveAVRPrice = new HashSet<>();
        for (PlasticGoods plasticItem: plasticGoods) {
            if(plasticItem.getPrice() < averagePrice())
                plasticGoodsAboveAVRPrice.add(plasticItem);
        }
        return plasticGoodsAboveAVRPrice;
    }



    @Override
    public String toString() {
        return "PlasticGoodsManufacturer{" +
                "name='" + name + '\'' +
                ", plasticGoods=" + plasticGoods +
                '}';
    }
}
