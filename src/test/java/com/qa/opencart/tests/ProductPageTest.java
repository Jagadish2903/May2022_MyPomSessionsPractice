package com.qa.opencart.tests;

import org.testng.Assert;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic( "Basic design of Product Page")
@Story("US103: Product Functionality check")
public class ProductPageTest extends BaseTest {
	
	@BeforeClass
	public void productSetUp() {
		accpage=lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	

	@Description("This is ProductPageitem test ")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void productCheckTest() {
		productpage=accpage.selectProduct(driver);
		String text=productpage.checkProduct();
		System.out.println(text);
		Assert.assertEquals(text, "Sauce Labs Backpack");
	}
	
	

	@Description("This is AddtoCartBTn test ")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void checkAddtoCartbtn() {
		productpage=accpage.selectProduct(driver);
		boolean addtocart=productpage.isaddToCartEnabled();
		Assert.assertEquals(addtocart, true);
	}
}
