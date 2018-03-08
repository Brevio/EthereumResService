import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.ethereum.services.AdminTrasaction;

public class Testes {
	private static AdminTrasaction ad = new AdminTrasaction();
	
	public static void main(String[] args) {
		Unit ether = Convert.Unit.ETHER;
		String address = "0xe16b6C3bdEc3231D532671083E93964Da6eEa062";
		try {
			BigInteger balance = ad.getBalance(address);
			
			System.out.println(balance);
			BigDecimal fromWei = Convert.fromWei(balance.toString(), ether);
			System.out.println(fromWei);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			System.out.println(ad.createWallet("luahelena"));
//		} catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException
//				| CipherException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			
//			System.out.println(ad.getBalance(address));
//			List<String> acc = ad.getListAccounts();
//			for (String string : acc) {
//				System.out.println(string);
//			}
//			
//		} catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
