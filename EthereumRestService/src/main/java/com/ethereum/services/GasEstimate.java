package com.ethereum.services;

import java.math.BigDecimal;

import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.ethereum.model.GasEstimateResponse;
import com.ethereum.util.Constantes;
import com.ethereum.util.GasUtil;
import com.ethereum.util.PropertiesUtil;

public class GasEstimate {
	public GasEstimateResponse estimate(int priority){
		GasEstimateResponse response = new GasEstimateResponse();
		BigDecimal result = new BigDecimal(0);
		switch (priority) {
		case 0:
			result = GasUtil.gasCalculater(PropertiesUtil.getProperties("gasHigh"));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setEstimate(result.toString());
			break;
		case 1:
			result = GasUtil.gasCalculater(PropertiesUtil.getProperties("gasMed"));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setEstimate(result.toString());
			break;
		case 2:
			result = GasUtil.gasCalculater(PropertiesUtil.getProperties("gasLow"));
			response.setCode(Constantes.CODE_SUCCESS);
			response.setStatus(Constantes.SUCCESS_STATUS);
			response.setEstimate(result.toString());
			break;
		default:
			response.setCode(Constantes.GAS_ESTIMATE_FAILURE);
			response.setStatus(Constantes.GAS_ESTIMATE_FAILURE_MSG);
			break;
		}
		return response;
	}

}
