package org.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.task.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
