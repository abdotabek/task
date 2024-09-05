package org.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
