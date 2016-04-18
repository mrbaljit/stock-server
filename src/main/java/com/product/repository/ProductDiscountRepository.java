package com.product.repository;

import com.product.domain.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by u342597 on 14/04/2016.
 */
@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount,Long> {
}
