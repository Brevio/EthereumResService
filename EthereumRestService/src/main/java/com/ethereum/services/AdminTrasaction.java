package com.ethereum.services;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.ethereum.model.AccountsResponse;
import com.ethereum.model.BalanceResponse;
import com.ethereum.model.NewWalletResponse;
import com.ethereum.util.Constantes;
import com.ethereum.util.PropertiesUtil;

public class AdminTrasaction {
	private Web3j web3j = Web3j.build(new HttpService());
	private Logger logger = LoggerFactory.getLogger(AdminTrasaction.class);
	public BalanceResponse getBalance(String address) {
		BalanceResponse response = new BalanceResponse();
		Unit ether = Convert.Unit.ETHER;
		EthGetBalance ethGetBalance;
		try {
			ethGetBalance = web3j
					.ethGetBalance(
							address,
							DefaultBlockParameterName.LATEST)
					.sendAsync()
					.get();
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			BigInteger valueBigInteger = ethGetBalance.getBalance();
			BigDecimal weiFormatEthet = Convert.fromWei(valueBigInteger.toString(), ether);
			response.setValueFormatEthet((weiFormatEthet));
			logger.info("getBalance - success");
		} catch (InterruptedException | ExecutionException e) {
			logger.error("getBalance - failure");
			logger.error(e.toString());
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
		}
		return response;
		
	}
	public AccountsResponse getListAccounts(){
		AccountsResponse response = new AccountsResponse();
		EthAccounts accounts;
		try {
			accounts = web3j
					.ethAccounts()
					.sendAsync()
					.get();
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setAccounts(accounts.getAccounts());
			logger.info("getListAccounts - success");
			
		} catch (InterruptedException | ExecutionException e) {
			logger.error("getListAccounts - failure");
			logger.error(e.toString());
			response.setCode(Constantes.ADMIN_FAILURE);
			response.setStatus(e.toString());
			
		}
		
		return response;
	}
	public NewWalletResponse createWallet(String password) {
		NewWalletResponse response = new NewWalletResponse();
		String walletDir;
		String[] newAddress;
		try {
			walletDir = WalletUtils
					.generateNewWalletFile(password, new File(PropertiesUtil.getProperties("PATH_WALLET")), true);
//							new File("C:\\ethereum\\homolog\\keystore\\"),true);
									
//									
			 newAddress = walletDir.split("Z--");
			 response.setWalletDir(walletDir);
			 response.setNewAddress("0x"+newAddress[1].substring(0, newAddress[1].length()-5)); // não sei se funcionara em produção 
			 response.setStatus(Constantes.SUCCESS_STATUS);
			 response.setCode(Constantes.CODE_SUCCESS);
			 logger.info("createWallet - success");
			 
		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException
				| CipherException | IOException e) {
			logger.error("createWallet - failure");
			logger.error(e.toString());
			response.setStatus(e.toString());
			response.setCode(Constantes.ADMIN_FAILURE);
		}
		 
		 return response;
		
	}
	
}
