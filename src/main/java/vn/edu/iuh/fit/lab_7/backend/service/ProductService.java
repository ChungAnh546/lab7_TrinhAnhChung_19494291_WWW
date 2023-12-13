package vn.edu.iuh.fit.lab_7.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab_7.backend.models.Product;
import vn.edu.iuh.fit.lab_7.backend.models.ProductPrice;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.lab_7.backend.repositories.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService extends abstractService<Product> {
    @Autowired
    private ProductRepository repository;

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return repository.findAll(pageable);
    }

    public Page<Product> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Product> list;
        List<Product> products = repository.findAll();
        if (products.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, products.size());
            list = products.subList(startItem, toIndex);
        }
        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), products.size());
    }
}
