package com.ethereum.controller;

import java.math.BigInteger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ethereum.model.BaseResponse;
import com.ethereum.model.PaymentRequest;
import com.ethereum.services.Transaction;
import com.ethereum.util.Constantes;

@RestController
@RequestMapping("/application.wadl/payment")
public class PaymentController {

	private final String sharedKey = "SHARED_KEY";
	

@RequestMapping(value = "/pay", method = RequestMethod.POST)
public BaseResponse pay(@RequestParam(value = "key") String key,@RequestBody PaymentRequest request) {


	BaseResponse response = new BaseResponse();
	
	if (sharedKey.equalsIgnoreCase(key)) {
		String fromWallet = request.getFromWallet();
		String toWallet = request.getToWallet();
		BigInteger value = request.getValue();
		response.setStatus(Constantes.SUCCESS_STATUS);
		response.setCode(Constantes.CODE_SUCCESS);
		
		System.out.println("fromWallet="+fromWallet+" toWallet= "+toWallet+" value="+value);
  } else {
	  response.setStatus(Constantes.ERROR_STATUS);
	  response.setCode(Constantes.AUTH_FAILURE);
  }
	
	Transaction send = new Transaction();
	try {
		send.sendWallet(request);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  return response;
 }
}