package com.ethereum.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BalanceResponse extends BaseResponse {
	private BigInteger valueBigInt;
	private BigDecimal valueFormatEthet;
	public BigDecimal getValueFormatEthet() {
		return valueFormatEthet;
	}
	public void setValueFormatEthet(BigDecimal valueFormatEthet) {
		this.valueFormatEthet = valueFormatEthet;
	}
	

}
