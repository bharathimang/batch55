package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import tests.BaseClass;

public class PropertyUntility extends BaseClass {
	
	
	
	public PropertyUntility() throws Throwable {
		File f=new File("src/test/resources/configuration/Application.properties");
		FileInputStream fis=new FileInputStream(f);		
		prop=new Properties();	
		prop.load(fis);
	}
	
	public String readDataFromPropertyFile(String key) throws Throwable {
	
		String value=prop.getProperty(key);
		return value;
		
	}
		
	public void writeDataPropertyFile(String key, String value) {
		
		// TO-DO
	}
	
	

}
