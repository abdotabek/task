package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.task.entity.User;
import org.test.task.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(User dto) {
        User user = new User();
       user.setId(dto.getId());
        userRepository.save(user);
        return user;
    }

    public User update(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.save(user);
        return user;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);

    }

    public User get(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
