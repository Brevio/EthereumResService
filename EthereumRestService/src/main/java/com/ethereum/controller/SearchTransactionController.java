package com.ethereum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ethereum.model.SearchResponse;
import com.ethereum.services.SearchTransactions;

@RestController
@RequestMapping("application.wadl/searchTransaction")
public class SearchTransactionController {
	private SearchTransactions search = new SearchTransactions();
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public SearchResponse getTransaction(@RequestParam(defaultValue="") String transactionHash){
			return search.search(transactionHash);
	}

}
