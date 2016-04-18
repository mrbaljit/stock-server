package com.stock.repository;

import com.stock.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by u342597 on 14/04/2016.
 */
@Repository
public interface StockRepository extends JpaRepository<Product,Long> {
}
