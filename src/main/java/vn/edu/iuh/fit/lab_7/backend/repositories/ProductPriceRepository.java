package vn.edu.iuh.fit.lab_7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.lab_7.backend.models.ProductPrice;
import vn.edu.iuh.fit.lab_7.backend.pks.ProductPricePK;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}