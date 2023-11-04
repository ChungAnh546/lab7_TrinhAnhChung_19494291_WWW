package vn.edu.iuh.fit.lab_7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.lab_7.backend.models.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}