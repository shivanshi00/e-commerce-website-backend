package com.casestudy.ecart.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CartId;
    @ManyToOne
    private Products products;
    @ManyToOne
    private Users users;
    @Column
    private int quantity;
//    @Column
//    private Double totalPrice;

    public Cart(Products products, Users users, int quantity)
    {
        this.products=products;
        this.users=users;
        this.quantity=quantity;
       // this.totalPrice=getTotalPrice();
    }

    public Cart()
    {

    }

    public Long getCartId() {
        return CartId;
    }

    public void setCartId(Long cartId) {
        CartId = cartId;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public Double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(Double totalPrice) {
//        this.totalPrice = totalPrice;
//    }


}
