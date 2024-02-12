package com.bankingApplication.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankingApplication.BankingApplication.dto.AccountDto;
import com.bankingApplication.BankingApplication.service.AccountService;

@RestController
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/api/accounts")
	private ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		return ResponseEntity.ok(accountService.getAccountById(id));
	}
	
	@PutMapping("/{id}/deposit")
	private ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> req){
		return ResponseEntity.ok(accountService.deposit(id, req.get("amount")));
	}
	
	@PutMapping("/{id}/withdraw")
	private ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> req){
		return ResponseEntity.ok(accountService.withdraw(id, req.get("amount")));
	}
	
	@GetMapping("/api/all")
	private ResponseEntity<List<AccountDto>> getAllAccounts(){
		return ResponseEntity.ok(accountService.displayAllAccounts());
	}
	
	@DeleteMapping("/{id}/delete")
	private ResponseEntity<String> delete(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted successfully !!");
	}
}