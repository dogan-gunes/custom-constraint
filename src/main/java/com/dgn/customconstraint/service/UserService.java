package com.dgn.customconstraint.service;

import com.dgn.customconstraint.exception.UserNotFoundException;
import com.dgn.customconstraint.model.User;
import com.dgn.customconstraint.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByPhoneNumber(String phoneNumber){
        return userRepository.findUserByPhoneNumber(phoneNumber)
                .orElseThrow(()->new UserNotFoundException("Belirttiğiniz Telefon Numarasına Ait Kayıt Bulunamadı ! Telefon Numarası : "+phoneNumber));
    }
}
