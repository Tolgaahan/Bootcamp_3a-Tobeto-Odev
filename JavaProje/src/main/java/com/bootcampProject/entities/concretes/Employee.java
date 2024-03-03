package com.bootcampProject.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor//anatasyon denir
@Entity//anatasyon denir
@Table(name="employees")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "userId")
public class Employee extends User {
    @Column(name = "position")
    private String position;
}