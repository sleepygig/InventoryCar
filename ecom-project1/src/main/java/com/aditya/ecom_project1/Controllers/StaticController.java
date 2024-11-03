package com.aditya.ecom_project1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class StaticController {

    @GetMapping("/add")
    public String showDeletePage() {
        return "Add"; // This looks for delete.html in the templates folder
    }
}
