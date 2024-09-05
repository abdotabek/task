package org.test.task.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.task.dto.ProductDTO;
import org.test.task.dto.ProductUpdateDTO;
import org.test.task.entity.Product;
import org.test.task.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid ProductDTO dto) {
        Product product1 = productService.create(dto);
        return ResponseEntity.ok(product1);

    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ProductUpdateDTO dto) {
        Product product = productService.update(id, dto);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        Product product = productService.get(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("get/list")
    public ResponseEntity<?> getList() {
        List<Product> result = productService.getList();
        return ResponseEntity.ok(result);
    }


}


