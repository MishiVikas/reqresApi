package com.restAssured.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.restAssured.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_01GET_ReqresAPI extends TestBase
{
	@Test
	public void getBody () 
	{
		RestAssured.baseURI = "https://reqres.in/api";
		
		httpRequest = RestAssured.given();
		
		Response = httpRequest.request(Method.GET, "/user");
		
		String respBody  = Response.getBody().asString();
		
		System.out.println("Responce body is " + respBody);
		
	}
	
	@Test
	public void verifyStatusCode()
	{
		int statusCode = Response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	@Test
	public void verifyStatusLine()
	{
		String statusLine = Response.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}
	
	@Test
	public void verifyresPonseTime()
	{
		long respTime = Response.getTime();
		System.out.println(respTime);
		Assert.assertTrue(respTime<2000);
	}
	
	@Test
	public void verifyHeader()
	{
		String header  = Response.getHeader("Server");
	
		Assert.assertTrue(header.contains("cloudflare"));
	}
	
	

}
