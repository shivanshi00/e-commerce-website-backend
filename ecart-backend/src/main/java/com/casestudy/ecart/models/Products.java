package com.casestudy.ecart.models;

import javax.persistence.*;

@Entity
@Table(name="productsInfo")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int pid;
    @Column(name="pname")
    private String productName;
    @Column(name="pquality")
    private int productQuality;
    @Column(name="price")
    double productPrice;
    @Column(name="description")
    private String description;
    @Column(name="modelno")
    private String modelNo;
    @Column(name="category")
    private String category;
    @Column(name="subcategory")
    private String subCategory;
    @Column(name="image")
    private String image;
    @Column(nullable = false, columnDefinition = "int default 1")
    private int active;


    public Products(){}
    public Products(String name){this.productName=name;}


    public int getId() {
        return pid;
    }

    public void setId(int id) {
        this.pid = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuality() {
        return productQuality;
    }

    public void setProductQuality(int productQuality) {
        this.productQuality = productQuality;
    }

    public double getPrductPrice() {
        return productPrice;
    }

    public void setPrductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
