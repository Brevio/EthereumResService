package com.ethereum.model;

import java.math.BigInteger;

public class PaymentRequest {

	private String fromWallet;
	private String password;
	private String toWallet;
	private BigInteger value;
	
	
	public void setFromWallet(String fromWallet){
		this.fromWallet=fromWallet;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getFromWallet(){
		return fromWallet;
	}
	public void setToWallet(String toWallet){
		this.toWallet=toWallet;
	}
	public String getToWallet(){
		return toWallet;
	}
	public void setValue(BigInteger value){
		this.value=value;
	}
	public BigInteger getValue(){
		return value;
	}
}
