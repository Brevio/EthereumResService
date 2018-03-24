package com.ethereum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ethereum.model.GasEstimateResponse;
import com.ethereum.services.GasEstimate;

@RestController
@RequestMapping("application.wadl/gasEstimate")
public class GasEstimateController {
	@RequestMapping(value = "/estimate", method = RequestMethod.POST)
	public GasEstimateResponse gasEstimate(@RequestParam(defaultValue="0") int priority){
		GasEstimate gas = new GasEstimate();
		return gas.estimate(priority);
	}

}
