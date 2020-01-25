package com.casestudy.ecart.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="order_history")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne
    private Products products;
    @Column(name = "price")
    private int price;
    @Column(nullable=false)
    LocalDate date;
    @ManyToOne
    private Users users;


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }



}
