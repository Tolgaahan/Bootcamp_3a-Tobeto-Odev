package com.bootcampProject.business.rules;

import com.bootcampProject.core.exceptions.BusinessException;
import com.bootcampProject.dataAccess.abstracts.EmployeeRepository;
import com.bootcampProject.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeRules {

    private EmployeeRepository employeeRepository;

    public void checkIfExists(String email) {
        Employee employee = employeeRepository.getByEmail(email.trim());
        if (employee != null) {
            throw new BusinessException("Bu e-posta adresi zaten kullanılıyor!");
        }
    }
}
