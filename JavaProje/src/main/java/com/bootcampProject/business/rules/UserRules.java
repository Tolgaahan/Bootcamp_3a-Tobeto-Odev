package com.bootcampProject.business.rules;

import com.bootcampProject.core.exceptions.BusinessException;
import com.bootcampProject.dataAccess.abstracts.UserRepository;
import com.bootcampProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRules {

    private UserRepository userRepository;

    public void checkIfExists(String email) {
        User user = userRepository.getByEmail(email.trim());
        if (user != null) {
            throw new BusinessException("Bu e-posta adresi zaten kullanılıyor!");
        }
    }
}
