package com.saad.tp.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saad.tp.entities.BankAccount;
import com.saad.tp.repository.BankAccountRepository;

@RestController
public class AccountRestController {
private BankAccountRepository bankAccountRepository;

public AccountRestController(BankAccountRepository bankAccountRepository) {
    this.bankAccountRepository = bankAccountRepository;
}
@GetMapping("/bankAccounts")
public List<BankAccount> bankAccounts()
{
 return bankAccountRepository.findAll();   
}
@GetMapping("/BankAccounts/{id}")
public BankAccount bankAccount(@PathVariable String id)
{
return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account not found") ));
}
@PostMapping("/BankAccounts")
public BankAccount save(@RequestBody BankAccount bankAccount)
{if(bankAccount.getId()!=null) bankAccount.setId(UUID.randomUUID().toString());
    if(bankAccount.getCreatedAt()!=null) bankAccount.setCreatedAt(new Date());
    
    return bankAccountRepository.save(bankAccount);
}
@PutMapping("/BankAccounts/{id}")
public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount)
{
    BankAccount account=bankAccountRepository.findById(id).orElseThrow();
account.setBalance(bankAccount.getBalance());
account.setCreatedAt(new Date());
account.setCurrency(bankAccount.getCurrency());
account.setType(bankAccount.getType());
return bankAccountRepository.save(account);
}
@DeleteMapping ("/BankAccounts/{id}")
public void deleteAccount(@PathVariable String id)
{
    bankAccountRepository.deleteById(id);
}


}
