package vn.edu.iuh.fit.lab_7.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_7.backend.models.Customer;
import vn.edu.iuh.fit.lab_7.backend.repositories.CustomerRepository;
import vn.edu.iuh.fit.lab_7.backend.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/list")
    public String showCustomerListPaging(Model model,
                                         @RequestParam("page")Optional<Integer> page,
                                         @RequestParam("size")Optional<Integer> size){
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(10);
    Page<Customer> customerPage = service.findPaginated(currentPage - 1, pageSize,"name","asc");
    model.addAttribute("customerPage",customerPage);
    int totalPages = customerPage.getTotalPages();
    if(totalPages>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);

    }
    return "admin/customer/listing";

    }
}
