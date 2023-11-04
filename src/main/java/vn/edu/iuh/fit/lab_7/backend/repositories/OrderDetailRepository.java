package vn.edu.iuh.fit.lab_7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.lab_7.backend.models.Order;
import vn.edu.iuh.fit.lab_7.backend.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Order> {
}