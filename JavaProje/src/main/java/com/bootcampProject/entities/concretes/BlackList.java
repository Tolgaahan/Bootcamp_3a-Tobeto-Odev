package com.bootcampProject.entities.concretes;

import com.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor//anatasyon denir
@NoArgsConstructor//anatasyon denir
@Table(name = "blacklist")
public class BlackList  extends BaseEntity<Integer>{


    @Column(name = "reason")
    private String reason;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;



}
