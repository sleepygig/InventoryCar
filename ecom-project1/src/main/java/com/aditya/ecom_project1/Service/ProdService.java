package com.aditya.ecom_project1.Service;

import com.aditya.ecom_project1.Models.Product;
import com.aditya.ecom_project1.Repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class ProdService {
    @Autowired
    private ProdRepo pr;


    public List<Product> getproducts() {
        return pr.findAll();
    }


    public void add(Product product)
    {


        pr.save(product);
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
        System.out.println(product.getBrand());
        System.out.println(product.getDescription());
        System.out.println(product.getQuantity());
        System.out.println(product);
    }

    public Product byid(int id) {
        return pr.findById(id).orElse(null);
    }

    public void update(Product q) {
        pr.save(q);
        System.out.println(q.getProductId());
        System.out.println(q.getProductName());
        System.out.println(q.getBrand());
        System.out.println(q.getDescription());
    }

    @DeleteMapping("/gets/{id}")
    public void delete(int id) {


        pr.deleteById(id);
    }
}
