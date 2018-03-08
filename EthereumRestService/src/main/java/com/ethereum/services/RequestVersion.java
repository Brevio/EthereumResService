package com.ethereum.services;

import java.io.IOException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

public class RequestVersion {
	
	private Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
	public String version() throws IOException{
	
		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
		return clientVersion;

	}
	


}
