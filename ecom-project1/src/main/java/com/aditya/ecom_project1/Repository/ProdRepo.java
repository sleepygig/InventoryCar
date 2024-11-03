package com.aditya.ecom_project1.Repository;

import com.aditya.ecom_project1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProdRepo extends JpaRepository<Product,Integer> {

    /// ORM interaction methods are defined here db with java objects

}
