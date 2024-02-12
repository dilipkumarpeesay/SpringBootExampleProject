package com.bankingApplication.BankingApplication.dto;

import jakarta.persistence.Column;

public class AccountDto {
	private Long id;
	private String holderName;
	private double balance;
	
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	public AccountDto(Long id, String holderName, double balance) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.balance = balance;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
