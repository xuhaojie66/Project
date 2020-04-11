package com.xhj.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> items= new ArrayList<>();

    private Double totalSumMoney;

    public ShoppingCart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalSumMoney() {
        this.totalSumMoney= new Double(0);
        for(Item i:items){
            this.totalSumMoney+=i.getSumMoney();
        }
        return totalSumMoney;
    }

    public void addCart(Product product){
        boolean b =false;
        for (Item i:items){
            if (product.getId().equals(i.getProduct().getId())){
                i.setNumber(i.getNumber()+1);
                b=true;
                break;
            }
        }
        if (!b){
            Item item = new Item();
            item.setId(this.items.size()+1);
            item.setProduct(product);
            items.add(item);
        }
    }

    public void removeCart(Product product){
        for (Item i:items){
            if (product.getId().equals(i.getProduct().getId())){
                items.remove(i);
                break;
            }
        }
    }
}
