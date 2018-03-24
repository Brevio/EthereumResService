package com.ethereum.model;
import java.util.List;

public class AccountsResponse extends BaseResponse {
	private List<String> accounts;

	public List<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}

}
