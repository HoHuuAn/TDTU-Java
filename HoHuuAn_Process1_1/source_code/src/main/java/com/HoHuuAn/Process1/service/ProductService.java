package com.HoHuuAn.Process1.service;

import com.HoHuuAn.Process1.model.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> listAll(int pageNumber, String sortField, String sortDir, String keyword);

    void addOrSave(Product product);

    Product getProductById(Long id);

    void deleteProductById(Long id);
}
