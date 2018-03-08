package com.ethereum.services;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;
import org.web3j.utils.Numeric;

import com.ethereum.util.Constantes;

public class CreateTransactions {
	
	protected static void send(Web3j web3, String from, String to, Credentials credentials, BigInteger value) {
		try {
			
			BigInteger nonce = getNonce(from, web3);
			BigInteger gasPrice = BigInteger.valueOf(20_000_000_000L);
			BigInteger gasLimit = BigInteger.valueOf(4_300_000);
			
			
			RawTransaction rawTransaction = RawTransaction.createEtherTransaction(nonce, gasPrice, gasLimit, to, value);

			byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
			String hexValue = Numeric.toHexString(signedMessage);

			EthSendTransaction ethSendTransaction = web3.ethSendRawTransaction(hexValue).sendAsync().get();
			String transactionHash = ethSendTransaction.getTransactionHash();

			EthGetTransactionReceipt transacao = web3.ethGetTransactionReceipt(transactionHash).sendAsync().get();
			System.out.println(transacao.getId());
			System.out.println(transacao.getJsonrpc());
			System.out.println(transactionHash);

		} catch (Exception e) {
		e.printStackTrace();
		//Faz o tratamento de erro
		}
		}
	private static BigInteger getNonce(String address, Web3j web3) throws Exception {
		EthGetTransactionCount ethGetTransactionCount = web3
				.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();

		BigInteger nonce = ethGetTransactionCount.getTransactionCount();
		return nonce;
}
}
