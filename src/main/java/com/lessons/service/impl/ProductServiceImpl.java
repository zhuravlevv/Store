package com.lessons.service.impl;

import com.lessons.entity.Product;
import com.lessons.repository.ProductRepository;
import com.lessons.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        try {
            return productRepository.findById(id).orElseThrow(Exception::new);
        } catch (Exception e){
            System.out.println("Product with id = " + id + " doesn't exist.");
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product newProduct, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
