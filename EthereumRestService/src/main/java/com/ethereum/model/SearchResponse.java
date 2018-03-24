package com.ethereum.model;

import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;

public class SearchResponse extends BaseResponse{
	private String statusTransaction;
	private EthGetTransactionReceipt transactionSearch;

	public String getStatusTransaction() {
		return statusTransaction;
	}

	public void setStatusTransaction(String statusTransaction) {
		this.statusTransaction = statusTransaction;
	}

	public EthGetTransactionReceipt getTransactionSearch() {
		return transactionSearch;
	}

	public void setTransactionSearch(EthGetTransactionReceipt transactionSearch) {
		this.transactionSearch = transactionSearch;
	}
	

}
