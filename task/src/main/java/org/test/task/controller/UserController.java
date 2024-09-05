package org.test.task.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.task.dto.UserDto;
import org.test.task.entity.User;
import org.test.task.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDto dto) {
        User user = new User();
        user.setId(dto.getUseId());
        userService.create(user);
        return ResponseEntity.ok(user);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id) {
        User user = userService.update(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        User user = userService.get(id);
        return ResponseEntity.ok(user);
    }

}
