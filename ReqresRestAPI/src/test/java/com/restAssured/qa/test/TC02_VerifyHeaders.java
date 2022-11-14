package com.restAssured.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restAssured.qa.base.TestBase;
import com.restAssured.qa.util.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC02_VerifyHeaders extends TestBase
{
    @DataProvider()
	@Test
	public void verifyHeader(String key, String value)
	{
		RestAssured.baseURI = "https://reqres.in/api";
		
		httpRequest = RestAssured.given();
		
		Response = httpRequest.request(Method.GET, "/user");
		
		String result = Response.getHeader(key);
		
		Assert.assertTrue(result.contains(value));
	}
    
    private String [][] getData() throws IOException
    {
    	String path = "./xl_TestData/ReqresTestData.xlsx";
    	int rownum = XLUtils.getRowCount(path, "header");
    	int cellnum = XLUtils.getcellCount(path, "header", 1);
    	
    	for(int i = 1; i<=rownum; i++)
    	{
    		for(int j = 0; j<cellnum; j++)
        	{
    			XLUtils.getCellData(path, "header", i, j);
        	}
    	}
    	return null;
    }
	
}
