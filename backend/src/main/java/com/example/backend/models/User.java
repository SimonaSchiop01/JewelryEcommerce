package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=50)
     private String firstName;

     @Column(nullable=false, length=50)
     private String lastName;

     @Column(unique=true, nullable=false, length=50)
     private String email;

     @Column(nullable = false, length=10)
     private String password;

     @Column(nullable = false)
     private Enum role;

     public void setEmail(String email) throws Exception{
         if(!email.contains("@yahoo")&&!email.contains("@gmail")){
             throw new Exception("Email-ul nu este valid");
         }
         this.email=email;
     }

     public void setPassword(String password) throws Exception{
         if(password.length()<6){
             throw new Exception("Parola trebuie sa contina minim 6 caractere");
         }
     }
}
