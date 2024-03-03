package com.bootcampProject.business.requests.create.blackList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlackListRequest {

    private int applicantId;
    private LocalDate date;
    private String reason;
}
