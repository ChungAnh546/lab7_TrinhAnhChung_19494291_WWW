package vn.edu.iuh.fit.lab_7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab_7.backend.enums.ProductStatus;
import vn.edu.iuh.fit.lab_7.backend.models.Product;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class LabTrinhAnhChung19494291WwwApplication {

    @Autowired
    private ProductRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(LabTrinhAnhChung19494291WwwApplication.class, args);
    }
//	@Bean
//    CommandLineRunner initData(){
//		return args -> {
//			Random rnd =new Random();
//
//			for (int i = 1; i < 100; i++) {
//				Product add = new Product("Pizza "+rnd.nextInt(1,1000),"Get our Manhattan Classic Cheese Pizza with your" +
//                        " choice of sauce and crust.","VND",
//						"Manufacturer"+rnd.nextInt(), ProductStatus.ACTIVE );
//				repository.save(add);
//
//
//				System.out.println("Product: " +add);
//			}
//		};
//	}
}
