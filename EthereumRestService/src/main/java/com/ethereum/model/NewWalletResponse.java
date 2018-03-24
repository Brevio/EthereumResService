package com.ethereum.model;

public class NewWalletResponse extends BaseResponse{
	
	private String newAddress;
	private String walletDir;
	
	public String getWalletDir() {
		return walletDir;
	}

	public void setWalletDir(String walletDir) {
		this.walletDir = walletDir;
	}

	public String getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(String newAddress) {
		this.newAddress = newAddress;
	}
}
