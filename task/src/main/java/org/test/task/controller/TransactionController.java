package org.test.task.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.task.service.TransactionService;
import org.test.task.dto.CreateTransactionResult;
import org.test.task.dto.TransactionDTO;
import org.test.task.entity.Transaction;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid TransactionDTO transactionDTO) {
        CreateTransactionResult result = transactionService.create(transactionDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("cashback/{userId}")
    public ResponseEntity<?> getCashback(@PathVariable("userId") Long userId) {
        Long result = transactionService.getCashback(userId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("list")
    public ResponseEntity<?> getList() {
        List<Transaction> result = transactionService.getList();

        return ResponseEntity.ok(result);
    }


}
