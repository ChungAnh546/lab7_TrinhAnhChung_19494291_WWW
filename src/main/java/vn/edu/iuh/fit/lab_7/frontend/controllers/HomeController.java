package vn.edu.iuh.fit.lab_7.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab_7.backend.models.Customer;
import vn.edu.iuh.fit.lab_7.backend.models.Product;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.lab_7.backend.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String showHomePaging(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size
    ) {
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(9));
        Page<Product> products = productService.findPaginated(pageable);
        model.addAttribute("products", products);
        int totalPages = products.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(page.orElse(1), page.orElse(1 + 5)
            ).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        Random rd = new Random();
       // int images[] = {1,2,3,4,5,6,7,8,9} ;
        model.addAttribute("images","3");
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
    public String showHomePage(Model model, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size
    ) {
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(9));
        Page<Product> products = productService.findPaginated(pageable);
        model.addAttribute("products", products);
        int totalPages = products.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(page.orElse(1), page.orElse(1 )+ 10
            ).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        Random rd = new Random();
        // int images[] = {1,2,3,4,5,6,7,8,9} ;
        model.addAttribute("images","3");
        return "index";

    }

    @GetMapping("/thank")
    public String showThankPaging(Model model) {

        return "thank-you-page";

    }


    @GetMapping("/buy/{id}")
    public String buyAction(HttpSession session, @PathVariable("id") long id){

        Optional<Product> product =  productRepository.findById(id);
        List<Product> lsproduct = null;
        Object obj = session.getAttribute("cart");
        if(obj == null){
            lsproduct = new ArrayList<>();
        }else{
            lsproduct = (ArrayList<Product>) obj;
        }
        lsproduct.add(product.get());
        session.setAttribute("cart",lsproduct);

        return "redirect:/";
    }
    @GetMapping("/products")
    public String checkout(Model model,HttpSession session){
        List<Product> products = (List<Product>) session.getAttribute("cart");
        model.addAttribute("products",products);
        return "products/products";
    }
    @GetMapping("/pay")
    public String pay(HttpSession session){
        session.removeAttribute("cart");
       //
        return "redirect:/";
    }
}
