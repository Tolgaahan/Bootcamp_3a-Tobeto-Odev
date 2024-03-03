package com.bootcampProject.dataAccess.abstracts;

import com.bootcampProject.entities.concretes.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlackListRepository  extends JpaRepository <BlackList, Integer> {
    List<BlackList> findByApplicantId(int applicantId);

    BlackList getByApplicantId(int id);
}
