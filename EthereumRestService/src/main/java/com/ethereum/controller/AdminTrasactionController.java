package com.ethereum.controller;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;

import com.ethereum.services.AdminTrasaction;

@RestController
@RequestMapping("/application.wadl/admin")
public class AdminTrasactionController {
	
	private AdminTrasaction admin = new AdminTrasaction();
	
	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public BigInteger getBalance(@RequestParam String address){
		BigInteger returno = null ;
		try {
			returno = admin.getBalance(address);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returno;
	}
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public List<String> listAccounts(){
		try {
			return admin.getListAccounts();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/newWallet", method = RequestMethod.POST)
	public String createWallet(@RequestParam String password) {
	try {
		return admin.createWallet(password);
	} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException | CipherException
			| IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return null;
		
	}

}
