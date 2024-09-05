package org.test.task.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.task.dto.CustomerCreateDTO;
import org.test.task.dto.UserDto;
import org.test.task.entity.Customer;
import org.test.task.entity.User;
import org.test.task.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid CustomerCreateDTO dto) {
        Customer customer = customerService.create(dto);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid CustomerCreateDTO dto) {
        Customer customer = customerService.update(id, dto);
        return ResponseEntity.ok(customer);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Customer customer = customerService.get(id);
        return ResponseEntity.ok(customer);
    }

}
