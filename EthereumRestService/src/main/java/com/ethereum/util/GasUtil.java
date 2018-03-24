package com.ethereum.util;

import java.math.BigDecimal;
import java.math.BigInteger;


public class GasUtil {

	public final static BigInteger gasLimit = new BigInteger(PropertiesUtil.getProperties("gasLimit"));
	public final static BigInteger gasLow = new BigInteger(PropertiesUtil.getProperties("gasLow"));
	public final static BigInteger gasMed = new BigInteger((PropertiesUtil.getProperties("gasMed")));
	public final static BigInteger gasHigh = new BigInteger((PropertiesUtil.getProperties("gasHigh")));
	public static BigDecimal gasCalculater(String gas){
		final double base = 0.000021;
		final int gwei = 1000000000;
		Double resultDouble = (Long.parseLong(gas) / gwei) * base;
		return  BigDecimal.valueOf(resultDouble);
				
	}
}
