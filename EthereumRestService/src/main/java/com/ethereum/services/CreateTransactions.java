package com.ethereum.services;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;
import org.web3j.utils.Convert.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ethereum.model.PaymentResponse;
import com.ethereum.util.Constantes;
import com.ethereum.util.GasUtil;

public class CreateTransactions {
	private static Logger logger = LoggerFactory.getLogger(CreateTransactions.class);
	
	
	protected static PaymentResponse send(Web3j web3, String from, String to, Credentials credentials, String value, BigInteger gasPrice) {
		PaymentResponse response = new PaymentResponse();
		Unit ether = Convert.Unit.ETHER;
		try {
			
			BigInteger nonce = getNonce(from, web3);
			BigInteger gasLimit = GasUtil.gasLimit; 
			BigDecimal wei = Convert.toWei(value, ether);
			BigInteger bigValue = wei.toBigInteger();

			RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, to, bigValue);

			byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
			String hexValue = Numeric.toHexString(signedMessage);

			EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get();
			if(ethSendTransaction.getError()==null){
				response.setStatus(Constantes.SUCCESS_STATUS);
				response.setCode(Constantes.CODE_SUCCESS);
				logger.info("send - success");
				response.setEthSendTransaction(ethSendTransaction);
				return response;
			}else{
				logger.error("send - failure");
				logger.error(ethSendTransaction.getError().getMessage());
				response.setStatus(ethSendTransaction.getError().getMessage());
				response.setCode(Constantes.TRANSACTION_FAILURE);
			}
			
		} catch (Exception e) {
			logger.error("send - failure");
			logger.error(e.toString());
			response.setStatus(e.toString());
			response.setCode(Constantes.TRANSACTION_FAILURE);
		}
		return response;
		}
	private static BigInteger getNonce(String address, Web3j web3) throws Exception {
		EthGetTransactionCount ethGetTransactionCount = web3
				.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		return nonce;
}
}
