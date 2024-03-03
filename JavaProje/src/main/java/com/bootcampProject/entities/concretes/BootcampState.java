package com.bootcampProject.entities.concretes;

import com.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootcampStates")
@PrimaryKeyJoinColumn(name = "userId")
public class BootcampState extends BaseEntity<Integer> {

    @NotBlank(message = "Ad alan boş olamaz")
    @Column(name = "name")
    private String name;
}
