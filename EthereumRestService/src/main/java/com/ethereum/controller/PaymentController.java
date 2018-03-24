package com.ethereum.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.ethereum.model.PaymentRequest;
import com.ethereum.model.PaymentResponse;
import com.ethereum.services.Transaction;
import com.ethereum.util.Constantes;

@RestController
@RequestMapping("application.wadl/payment")
public class PaymentController {
@RequestMapping(value = "/pay", method = RequestMethod.POST)
public PaymentResponse pay(@RequestBody PaymentRequest request) {
		Transaction send = new Transaction();
		PaymentResponse response = new PaymentResponse();
		if(request.getFromWallet().equalsIgnoreCase(request.getToWallet())){
			response.setStatus("Operação não permitida! Carteira de origem não pode ser a mesma de destino.");
			response.setCode(Constantes.TRANSACTION_FAILURE);
		}else{
			try {
				return send.sendWallet(request);
			} catch (Exception e) {
				e.printStackTrace();
				response.setStatus(e.toString());
				response.setCode(Constantes.TRANSACTION_FAILURE);
			}
		}
		return response;
 }
}