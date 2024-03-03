package com.bootcampProject.business.rules;

import com.bootcampProject.core.exceptions.BusinessException;
import com.bootcampProject.dataAccess.abstracts.BlackListRepository;
import com.bootcampProject.entities.concretes.BlackList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlackListRules {

    private BlackListRepository blacklistRepository;

    public void checkIfExists(int id) {
        BlackList blacklist = blacklistRepository.getByApplicantId(id);
        if (blacklist != null) {
            throw new BusinessException("Zaten kara listede!");
        }
    }
}
