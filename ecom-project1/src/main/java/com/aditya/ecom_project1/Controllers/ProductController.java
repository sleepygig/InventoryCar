package com.aditya.ecom_project1.Controllers;

import com.aditya.ecom_project1.DTO.ProductDto;
import com.aditya.ecom_project1.Models.Product;
import com.aditya.ecom_project1.Repository.ProdRepo;
import com.aditya.ecom_project1.Service.ProdService;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.math.BigDecimal;
import java.sql.Struct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin  // Set the exact origin
@RequestMapping("/api/products/")
public class ProductController {
    @Autowired
    private ProdService p; // Assume this service fetches the product data
    @Autowired
    private ProdRepo pr;


    @GetMapping("gets")
    public String fs(Model model) {
        List<Product> products;
        products = p.getproducts();
        model.addAttribute("products", products);
        return "home";
    }

    // Change this method to serve the HTML page
    @GetMapping("get")
    public ResponseEntity<Object> getAllProducts(Model model) {
        List<Product> products;
        products = p.getproducts(); // Fetch the product list
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    @PostMapping("add")
//    public ResponseEntity<String> add(@RequestBody Product pro) {
////        Product pr=new Product(pro.getProductName(),)
//        p.add(pro);
//        return new ResponseEntity<>("added",HttpStatus.OK);
//
//    }

    @GetMapping("{id}")
    public ResponseEntity<Product> byid(@PathVariable int id) {
        Product qw = p.byid(id);
        if (qw != null)
            return new ResponseEntity<>(qw, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping("api/products/update")
//    ResponseEntity<Snippet.Status> update(@RequestBody Product q) {
//        p.update(q);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @DeleteMapping("{id}")
//    ResponseEntity<String>delete(@PathVariable int id)
//    {
//        p.delete(id);
//        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        // Call service to delete the product by ID
        p.delete(id);  // Assumin   g delete(int id) in ProdService deletes the product

        // Redirect to the product list page after deletion
        return "redirect:/api/products/gets";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        // Save the product logic
        p.add(product);

        // Add a success message to the redirect attributes
        redirectAttributes.addFlashAttribute("message", "Product added successfully!");

        // Redirect to the product list page (assuming it's mapped to "/products")
        return "redirect:/api/products/gets";
    }


    @PostMapping("update")
    String update(@ModelAttribute Product product) {
        p.update(product);
        return "redirect:/api/products/gets";
    }
}
// DTO for Product to accept incoming d
