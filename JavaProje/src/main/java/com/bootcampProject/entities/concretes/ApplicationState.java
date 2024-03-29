package com.bootcampProject.entities.concretes;

import com.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applicationStates")
@PrimaryKeyJoinColumn(name = "userId")
public class ApplicationState extends BaseEntity<Integer> {
    @Column(name = "name")
    private String name;
}
