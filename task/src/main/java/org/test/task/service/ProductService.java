package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.test.task.dto.ProductDTO;
import org.test.task.dto.ProductUpdateDTO;
import org.test.task.entity.Product;
import org.test.task.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("create")
    public Product create(ProductDTO dto) {
        Product product1 = new Product(dto.getName(), dto.getPrice());
        productRepository.save(product1);
        return product1;
    }


    public Product update(Integer id, ProductUpdateDTO dto) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        productRepository.save(product);
        return product;

    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    public Product get(Integer id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getList() {
        return productRepository.findAll();
    }
}
