package com.example.demo.entity;

import com.example.demo.dto.UserCreateDto;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "talabalars")
@Entity
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;
    private String telephoneNumber;
    private String address;
    private String email;


    public UserEntity(UserCreateDto dto){
        this.name = dto.getName();
        this.telephoneNumber = dto.getTelephoneNumber();
        this.address = dto.getAddress();
        this.email = dto.getEmail();
    }

}
