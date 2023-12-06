package com.amazon.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData 
{	
	public static String fromExcel(String fileName, String 
			sName, int rIndex, int cIndex)
	{
		String data= null;
		try
		{
			//File f = new File("./data/"+fileName+".xlsx");
			File f = new File("D:\\Teaching\\Ingenious_TechHub_Teaching\\Ingenious_TechHub_Teaching\\Ingenious_Manual Testing\\AmazonTestCase.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sName);
			Row r = st.getRow(rIndex);
			Cell c = r.getCell(cIndex);
			data = c.toString();
		}
		catch(Exception e)
		{
			
		}
		return data;
	}
public static String fromProperties(String fileName, String key)
	{
		String value = null;
		try
		{
			//File f = new  File("./config/"+fileName+".properties");
			File f=new File("D:\\TestNGPractice\\AmazonPay\\config\\config.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
}
