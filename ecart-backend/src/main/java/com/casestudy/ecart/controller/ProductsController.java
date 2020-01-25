package com.casestudy.ecart.controller;

import com.casestudy.ecart.Repository.ProductRepository;
import com.casestudy.ecart.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    ProductRepository p;
    @GetMapping("/product")
    public List<Products> getAllProducts()
    {
        return p.findAll();
    }
    @GetMapping("/product/{id}")
    public Optional<Products> getProductById(@PathVariable(value="id")int productId)
    {
        return p.findById(productId);
    }
    @PostMapping("/create")
    public Products createNode(@Valid @RequestBody Products p1)
    {
        return p.save(p1);
    }
    @GetMapping("/product/category/{category}")
    public List<Products> getProductByCategory(@PathVariable(value="category")String category)
    {
        return p.findByCategory(category);
    }
    @GetMapping("/getByPrice/{price1}/{price2}")
    public List<Products> getProductByPrice(@PathVariable(value="price1")double p_price1, @PathVariable(value="price2")double p_price2)
    {
        return p.findAllByProductPriceBetween(p_price1, p_price2);
    }

}
