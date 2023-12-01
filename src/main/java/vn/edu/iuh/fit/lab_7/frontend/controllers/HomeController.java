package vn.edu.iuh.fit.lab_7.frontend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_7.backend.models.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePaging(Model model) {

        return "index";

    }
    @GetMapping("/about")
    public String showAboutPaging(Model model) {

        return "About";

    }
    @GetMapping("/contact")
    public String showContactPaging(Model model) {

        return "Contact";

    }
    @GetMapping("/home")
    public String showHomePage(Model model) {

        return "Home";

    }

    @GetMapping("/thank")
    public String showThankPaging(Model model) {

        return "thank-you-page";

    }
    @GetMapping("/products")
    public String showProductPaging(Model model) {

        return "products/products";

    }
}
