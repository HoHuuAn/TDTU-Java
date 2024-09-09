package com.HoHuuAn.Process1.service.impl;


import com.HoHuuAn.Process1.model.Product;
import com.HoHuuAn.Process1.repository.ProductRepository;
import com.HoHuuAn.Process1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> listAll(int pageNumber, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort =  sortDir.equals("asc") ?  sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(pageNumber-1, 10, sort);
        if(keyword != null){
            return productRepository.findAll(keyword, pageable);
        }
        return productRepository.findAll(pageable);
    }


    @Override
    public void addOrSave(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


}
