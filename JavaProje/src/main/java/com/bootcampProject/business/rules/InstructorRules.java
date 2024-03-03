package com.bootcampProject.business.rules;

import com.bootcampProject.core.exceptions.BusinessException;
import com.bootcampProject.dataAccess.abstracts.InstructorRepository;
import com.bootcampProject.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InstructorRules {


    private InstructorRepository instructorRepository;


    public void checkIfExists(String email) {
        Instructor instructor = instructorRepository.getByEmail(email.trim());
        if (instructor != null) {
            throw new BusinessException("Bu e-posta adresi zaten kullanılıyor!");
        }
    }
}
