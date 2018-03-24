package com.ethereum.model;

import org.web3j.protocol.core.methods.response.EthSendTransaction;

public class PaymentResponse extends BaseResponse{
	private EthSendTransaction ethSendTransaction;
	public EthSendTransaction getEthSendTransaction() {
		return ethSendTransaction;
	}
	public void setEthSendTransaction(EthSendTransaction ethSendTransaction) {
		this.ethSendTransaction = ethSendTransaction;
	}
}
