package com.bootcampProject.business.requests.create.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    private int id;
    private String companyName;
}
