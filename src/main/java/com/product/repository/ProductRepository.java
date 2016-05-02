package com.product.repository;

import com.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by u342597 on 14/04/2016.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByProductCode(String productCode);

    List<Product> findByProductCodeContainingIgnoreCase(String productCode);

}
