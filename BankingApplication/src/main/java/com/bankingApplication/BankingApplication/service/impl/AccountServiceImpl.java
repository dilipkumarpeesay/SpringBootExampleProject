package com.bankingApplication.BankingApplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

import com.bankingApplication.BankingApplication.dto.AccountDto;
import com.bankingApplication.BankingApplication.entity.Account;
import com.bankingApplication.BankingApplication.mapper.AccountMapper;
import com.bankingApplication.BankingApplication.repository.AccountRepository;
import com.bankingApplication.BankingApplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
private AccountRepository accountRepository;

// Better to use constructor rather than using @Autowired
// This is called constructor injection
public AccountServiceImpl(AccountRepository accountRepository) {
	super();
	this.accountRepository = accountRepository;
}

@Override
public AccountDto createAccount(AccountDto accountDto) {
	Account account = AccountMapper.mapToAccount(accountDto);
	Account saveAccount = accountRepository.save(account);
	return AccountMapper.mapToAccountDto(saveAccount);
}

@Override
public AccountDto getAccountById(Long id) {
	Account accountById = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist for given id"));
	return AccountMapper.mapToAccountDto(accountById);
}

@Override
public AccountDto deposit(Long id, double amount) {
	Account accountById = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist for given id"));
	double totalBalance = accountById.getBalance()+amount;
	accountById.setBalance(totalBalance);
	Account savedAccount = accountRepository.save(accountById);
	return AccountMapper.mapToAccountDto(savedAccount);
}

@Override
public AccountDto withdraw(Long id, double amount) {
	Account accountById = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist for given id"));
	if(accountById.getBalance() < amount) {
		throw new RuntimeException("You have insufficient balance!");
	}
	double totalBalance = accountById.getBalance()-amount;
	accountById.setBalance(totalBalance);
	Account savedAccount = accountRepository.save(accountById);
	return AccountMapper.mapToAccountDto(savedAccount);
}

@Override
public List<AccountDto> displayAllAccounts() {
	return accountRepository.findAll().stream().map((a)->AccountMapper.mapToAccountDto(a)).collect(Collectors.toList());
}

@Override
public void deleteAccount(Long id) {
	Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist for given id"));
	accountRepository.delete(account);
}

}
