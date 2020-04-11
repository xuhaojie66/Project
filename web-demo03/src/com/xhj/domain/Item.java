package com.xhj.domain;

public class Item {
    private Integer id;
    private Product product;
    private Integer number=1;
    private Double sumMoney;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getSumMoney() {
        sumMoney=this.product.getPrice()*this.number;
        return sumMoney;
    }
}
