package com.saad.tp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saad.tp.entities.BankAccount;
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
