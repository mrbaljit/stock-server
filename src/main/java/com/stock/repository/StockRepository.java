package com.stock.repository;

import com.stock.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by u342597 on 14/04/2016.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
