package vn.edu.iuh.fit.lab_7.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.lab_7.backend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}