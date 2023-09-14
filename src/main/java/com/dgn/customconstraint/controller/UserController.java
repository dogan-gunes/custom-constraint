package com.dgn.customconstraint.controller;

import com.dgn.customconstraint.model.User;
import com.dgn.customconstraint.service.UserService;
import com.dgn.customconstraint.validation.Dogan;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserByPhoneNumber/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable
                                                     @Dogan
                                                     @Valid
                                                     String phoneNumber) {

        return new ResponseEntity<>(userService.getUserByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
