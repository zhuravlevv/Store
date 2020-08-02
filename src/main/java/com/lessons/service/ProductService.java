package com.lessons.service;

import com.lessons.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product getById(Integer id);

    public Product save(Product product);

    public Product update(Product newProduct, Integer id);

    public void delete(Integer id);
}
