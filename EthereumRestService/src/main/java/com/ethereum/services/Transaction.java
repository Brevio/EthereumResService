package com.ethereum.services;

import java.io.File;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import com.ethereum.model.PaymentRequest;
import com.ethereum.util.Constantes;
import com.ethereum.util.PropertiesUtil;

public class Transaction {
	private Web3j web3 = Web3j.build(new HttpService());
		
	public void sendWallet(PaymentRequest payment) throws InterruptedException, TransactionException, Exception{
		Credentials credentials = WalletUtils
				.loadCredentials(payment.getPassword(),
						getDir(payment.getFromWallet()));
		CreateTransactions
		.send(web3,
				payment.getFromWallet(),
				payment.getToWallet(),
				credentials,
				payment.getValue());
	}

	private String getDir(String fromWallet) {
		String pathWallets = PropertiesUtil.getProperties("PATH_WALLET");
		
		File baseFolder = new File(pathWallets);
		File[] wallets = baseFolder.listFiles();
		
		for (File file : wallets) {
			file.getAbsolutePath();
			if(file.getName().contains(fromWallet.substring(2))){
				return file.getAbsolutePath();
			}
		}
		return null;
	}
}
