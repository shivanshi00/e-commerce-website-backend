package com.casestudy.ecart.Repository;

import com.casestudy.ecart.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByCategory(String category);
    List<Products> findAllByProductPriceBetween(double p_price1, double p_price2);
    Products findByPid(int id);
}
