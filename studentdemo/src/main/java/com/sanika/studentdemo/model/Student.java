package com.sanika.studentdemo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotBlank(message="Name should not be empty")
    @Size(min=5,message = "Name should have atleast 5 characters")
    private String name;

    @NotBlank(message="Email cannot be empty")
    @Email(message = "Enter a valid email")
    public String email;
    public Student(){

    }
    public Student(int id,String name,String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public void setId (int id){
        this.id=id;
    }
    public void setName (String name){
        this.name=name;
    }
    public void setEmail (String email){
        this.email=email;
    }
    public int getId(){
       return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
