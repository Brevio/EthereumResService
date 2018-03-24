package com.ethereum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ethereum.model.RemoveResponse;
import com.ethereum.services.RemoveAccount;

@RestController
@RequestMapping("application.wadl/removeAccount")
public class RemoveAccountController {
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public RemoveResponse remove(@RequestParam(defaultValue="") String account){
		RemoveAccount remove = new RemoveAccount();
		return remove.remove(account);
		
	}
}
