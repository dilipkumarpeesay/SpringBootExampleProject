package com.bankingApplication.BankingApplication.mapper;

import com.bankingApplication.BankingApplication.dto.AccountDto;
import com.bankingApplication.BankingApplication.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
		accountDto.getId(),
		accountDto.getHolderName(),
		accountDto.getBalance()
		);
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getHolderName(),
				account.getBalance()
		);
		return accountDto;
	}
}