package com.bootcampProject.business.rules;


import com.bootcampProject.core.exceptions.BusinessException;
import com.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.bootcampProject.entities.concretes.Bootcamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BootcampRules {

    private BootcampRepository bootcampRepository;
    public void checkIfExists(String name) {
        Bootcamp bootcamp = bootcampRepository.getByName(name.trim());
        if (bootcamp != null) {
            throw new BusinessException("Bu isimde bir bootcamp zaten var!");
        }
    }
}
