package com.ethereum.services;

import java.io.File;

import com.ethereum.model.RemoveResponse;
import com.ethereum.util.Constantes;

public class RemoveAccount extends Transaction{

	public RemoveResponse remove(String address){
		RemoveResponse response = new RemoveResponse();
		File wallet = new File( getDir(address));
		if(wallet.exists()){
			response.setAccount(address);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setCode(Constantes.CODE_SUCCESS);
			response.setDeleted(wallet.delete());
			
		}else{
			response.setAccount(address);
			response.setCode(Constantes.SEARCH_FAILURE);
			response.setDeleted(false);
		}
		return response;
	}
}
