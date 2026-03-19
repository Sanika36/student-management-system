package com.sanika.studentdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 5, message = "Name should have atleast 5 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail (){
        return email ;
    }

    public void setEmail (String email){
        this.email=email;
    }
}