package com.yyq.project.product.repository;

import com.yyq.project.product.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yangyunqi on 2017/8/3.
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    List<OrderDetails> findByOrderId(String orderId);
}
