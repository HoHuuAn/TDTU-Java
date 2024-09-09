package com.HoHuuAn.Process1.repository;

import com.HoHuuAn.Process1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.brand, ' ',p.madein, ' ',p.price) LIKE %?1%")
    public Page<Product> findAll(String keyword, Pageable pageable);
}
