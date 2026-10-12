package com.saad.tp.entities;

import java.util.Date;

import com.saad.tp.enums.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor 
public class BankAccount {
@Id @GeneratedValue(strategy = GenerationType.UUID)
private String id;
private Date createdAt;
private double balance;
private String currency;
private  AccountType type ;

}
