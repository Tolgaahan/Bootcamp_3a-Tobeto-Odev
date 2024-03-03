package com.bootcampProject.entities.concretes;

import com.bootcampProject.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<Integer> {

    @NotBlank(message = "Ad alan boş olamaz")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Ad alan boş olamaz")
    @Column(name = "firstName")
    private String firstName;

    @NotBlank(message = "Ad alan boş olamaz")
    @Column(name = "lastName")
    private String lastName;

    @Past(message = "Geçerli bir doğum tarihi giriniz")
    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "nationalIdentity")
    private String nationalIdentity;

    @NotBlank(message = "E-posta adresi alan boş olamaz")
    @Email(message = "Geçersiz e-posta adresi")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Ad alan boş olamaz")
    @Size(min = 7, max = 15, message = "Ad en az 7, en fazla 15 karakter olmalıdır")
    @Column(name = "password")
    private String password;
}