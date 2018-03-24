package com.ethereum.model;

public class PaymentRequest {

	private String fromWallet;
	private String password;
	private String toWallet;
	private String value;
	private int gasPricePriority;
	
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
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return value;
	}
	public int getGasPricePriority() {
		return gasPricePriority;
	}
	public void setGasPricePriority(int gasPricePriority) {
		this.gasPricePriority = gasPricePriority;
	}
}

