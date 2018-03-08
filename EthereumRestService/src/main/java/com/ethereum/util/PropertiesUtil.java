package com.ethereum.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties props = new Properties();
	public static String getProperties(String key){
		InputStream in=null;
		try {
			in = new FileInputStream("/home/devel/worketh/SpringRestService/src/main/resources/service.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!props.isEmpty()){
			return props.getProperty(key);
		}
		return null;
	}
}
