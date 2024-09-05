package org.test.task.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.test.task.entity.Transaction;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query("select sum(w.cashbackAmount) from Transaction w where w.user.id = ?1")
    Long getCashback(Long userId);

}
