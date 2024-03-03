package com.bootcampProject.business.responses.get.blackList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBlackListResponse {

    private int userId;
    private int id;
    private String reason;
    private Date date;
    private int applicantId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;

}
