import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Convert.Unit;

import com.ethereum.model.PaymentRequest;
import com.ethereum.services.AdminTrasaction;
import com.ethereum.services.RemoveAccount;
import com.ethereum.services.SearchTransactions;
import com.ethereum.services.Transaction;
import com.ethereum.services.UpdatePassword;
import com.ethereum.util.GasUtil;
import com.ethereum.util.PropertiesUtil;

public class Testes {
	private static AdminTrasaction ad = new AdminTrasaction();
	private static Web3j web3 = Web3j.build(new HttpService());
	
	public static void main(String[] args) {
		
	

		BigInteger valueFormatEthet = ad.getBalance("0xe5c46575dB7b76Aaf6D612AAe5EF94B802d982Db").getValueFormatEthet().toBigInteger();
		Long price = Long.parseLong(PropertiesUtil.getProperties("gasHigh"));
		
		
	//	System.out.println(ad.getBalance("0xe5c46575dB7b76Aaf6D612AAe5EF94B802d982Db").getValueFormatEthet());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		UpdatePassword up = new UpdatePassword();
//		up.Update("0x908E5BE2642749C4B81492F88910B83721Db109d", "12345678", "luahelena");
//					 
		
		
		
//		
//		String big = "1";
//		Transaction t = new Transaction();
//		PaymentRequest payment = new PaymentRequest();
//		payment.setFromWallet("0xe5c46575dB7b76Aaf6D612AAe5EF94B802d982Db");
//		payment.setPassword("12345678");
//		payment.setToWallet("0x908E5BE2642749C4B81492F88910B83721Db109d");
//		payment.setValue(big);
//		
//		try {
//			System.out.println(t.sendWallet(payment).getEthSendTransaction().getTransactionHash());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		RemoveAccount remove = new RemoveAccount();
//		remove.remove("0x167524ceC12a5274D9F5dd363F673A144eB84C21");
		
		
		SearchTransactions ser = new  SearchTransactions();
//		String ret = ser.search(web3, "0xd21dfa6e286f1f20c37fea6edbae839ec840490d7ef8a0e2f0eadaa49f02ddb9").getResult().toString();
//		System.out.println(ret);
		
//		AdminTrasaction ad = new AdminTrasaction();
//		
//		for(int i=0;i<2000;i++){
//			ad.createWallet("123");
//		}
//	
//	
		}

}
