package com.ethereum.services;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;

import com.ethereum.util.PropertiesUtil;

public class AdminTrasaction {

	private Web3j web3j = Web3j.build(new HttpService());
	public BigInteger getBalance(String address) throws InterruptedException, ExecutionException{
		EthGetBalance ethGetBalance = web3j
				.ethGetBalance(
						address,
						DefaultBlockParameterName.LATEST)
				.sendAsync()
				.get();
		BigInteger wei = ethGetBalance.getBalance();
		return wei;
		
	}
	public List<String> getListAccounts() throws InterruptedException, ExecutionException{
		EthAccounts accounts = web3j
				.ethAccounts()
				.sendAsync()
				.get();
		
		return accounts.getAccounts();
	}
	public String createWallet(String password) 
			throws InvalidAlgorithmParameterException,
	NoSuchAlgorithmException, NoSuchProviderException, CipherException, IOException{
		
		return  WalletUtils
				.generateNewWalletFile(password,
						new File(PropertiesUtil.getProperties("PATH_WALLET")), true);
		
	}
	
}
