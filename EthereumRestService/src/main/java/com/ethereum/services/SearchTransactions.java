package com.ethereum.services;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.http.HttpService;

import com.ethereum.model.SearchResponse;
import com.ethereum.util.Constantes;

public class SearchTransactions {
	
	private Web3j web3 = Web3j.build(new HttpService());
	private static Logger logger = LoggerFactory.getLogger(SearchResponse.class);
	
	public SearchResponse search(String transactionHash){
		EthGetTransactionReceipt transaction = null;
		SearchResponse response = new SearchResponse();
		try {
			 transaction = web3.ethGetTransactionReceipt(transactionHash).sendAsync().get();
			 
			 if(transaction.getError()==null){
				 response.setStatusTransaction(Constantes.TRANSACTION_DONE);
				 response.setCode(Constantes.CODE_SUCCESS);
				 response.setStatus(Constantes.SUCCESS_STATUS);
				 response.setTransactionSearch(transaction);
				 logger.info("searchResponse - success");
			 }else{
				 response.setStatusTransaction(Constantes.TRANSACTION_FAIL);
				 response.setCode(Constantes.SEARCH_FAILURE);
				 response.setStatus(Constantes.ERROR_STATUS);
				 response.setTransactionSearch(transaction);
				 logger.error("searchResponse - fail");
			 }
		} catch (InterruptedException | ExecutionException e) {
			
			
			logger.error("searchResponse - fail : "+e);
			
		}
		return response;
	}
	
}
