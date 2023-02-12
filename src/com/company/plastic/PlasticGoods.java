package com.company.plastic;

public class PlasticGoods implements Comparable<PlasticGoods> {
    private String name;
    private double price;

    public PlasticGoods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public PlasticGoods() {

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PlasticGoods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(PlasticGoods o) {
        return Double.compare(this.price,o.price);
    }
}
