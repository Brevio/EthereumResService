package com.ethereum.services;

import java.io.File;
import java.io.IOException;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletUtils;

import com.ethereum.model.UpdatePasswordRequest;
import com.ethereum.model.UpdatePasswordResponse;
import com.ethereum.util.Constantes;
import com.ethereum.util.PropertiesUtil;

public class UpdatePassword extends Transaction{
	public UpdatePasswordResponse update(UpdatePasswordRequest request){
		RemoveAccount remove = new RemoveAccount();
		UpdatePasswordResponse response = new UpdatePasswordResponse();
		try {
			ECKeyPair keypair = WalletUtils.loadCredentials(request.getOldPassword(), getDir(request.getAddress())).getEcKeyPair();
			remove.remove(request.getAddress());
			WalletUtils.generateWalletFile(request.getNewPassword(), keypair,new File(PropertiesUtil.getProperties("PATH_WALLET")), true);
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setAddress(request.getAddress());
		} catch (CipherException | IOException e) {
			response.setCode(Constantes.UPDATE_FAILURE);
			response.setStatus(e.toString());
			response.setAddress(request.getAddress());
		}
		return response;
	}

}
