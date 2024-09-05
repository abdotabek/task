package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.task.dto.CreateTransactionResult;
import org.test.task.dto.TransactionDTO;
import org.test.task.entity.Customer;
import org.test.task.entity.Product;
import org.test.task.entity.Transaction;
import org.test.task.entity.User;
import org.test.task.repository.CustomerRepository;
import org.test.task.repository.ProductRepository;
import org.test.task.repository.TransactionRepository;
import org.test.task.repository.UserRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public CreateTransactionResult create(TransactionDTO dto) {
        List<Product> products = productRepository.findAllById(dto.getProductIds());

        Long amount = 0L;
        Long cashbackAmount = 0L;
        for (Product p : products) {
            amount += p.getPrice();
            cashbackAmount += ((long) p.getPrice() / 100);
        }


        User user = userRepository.findById(dto.getUserId()).orElseThrow();

        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow();



        Transaction transaction = new Transaction(user,customer, amount, cashbackAmount, products);
        transaction = transactionRepository.save(transaction);

        return new CreateTransactionResult(transaction.getId(),  transaction.getAmount(),
                transaction.getCashbackAmount(), transaction.getProducts(),
                transaction.getUser().getId(),transaction.getCustomer().getId());
    }

    public Long getCashback(Long userId) {
        return transactionRepository.getCashback(userId);


    }

    public List<Transaction> getList() {
        return transactionRepository.findAll();
    }

}
