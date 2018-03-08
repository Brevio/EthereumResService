package com.ethereum.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ethereum.model.VersionResponse;
import com.ethereum.services.RequestVersion;
import com.ethereum.util.Constantes;

@RestController
@RequestMapping("/application.wadl/version")
public class RequestVersionController {
	
	
	private RequestVersion version = new RequestVersion();
	private VersionResponse response = new VersionResponse();
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public VersionResponse request(){
		try {
			response.setVersion(version.version());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(response.getVersion()!=null){
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setCode(Constantes.CODE_SUCCESS);
		}else{
			response.setStatus(Constantes.ERROR_STATUS);
			response.setCode(Constantes.GETH_FAILURE);
		}
		System.out.println(response.getStatus());
		
		return response;
	}
}
