package com.ethereum.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ethereum.model.AccountsResponse;
import com.ethereum.model.BalanceResponse;
import com.ethereum.model.NewWalletResponse;
import com.ethereum.services.AdminTrasaction;

@RestController
@RequestMapping("application.wadl/admin")
public class AdminTrasactionController {
	
	private AdminTrasaction admin = new AdminTrasaction();
	
	@RequestMapping(value = "/balance", method = RequestMethod.POST)
	public BalanceResponse getBalance(@RequestParam(defaultValue="") String address){
			return admin.getBalance(address);
	}
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public AccountsResponse listAccounts(){
		return admin.getListAccounts();
	}
	@RequestMapping(value = "/newWallet", method = RequestMethod.POST)
	public NewWalletResponse createWallet(@RequestParam (defaultValue="") String password) {
		return admin.createWallet(password);
	}

}
