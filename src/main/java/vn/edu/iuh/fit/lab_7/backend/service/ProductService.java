package vn.edu.iuh.fit.lab_7.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_7.backend.models.Product;
import vn.edu.iuh.fit.lab_7.backend.models.ProductPrice;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductRepository;

@Service
public class ProductService extends abstractService<Product> {
    @Autowired
    private ProductRepository repository;
    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection),sortBy);
        Pageable pageable = PageRequest.of(pageNo,pageSize,sort);
        return repository.findAll(pageable);
    }
}
