package org.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.task.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
