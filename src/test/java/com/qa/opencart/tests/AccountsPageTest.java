package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsPageTest extends BaseTest{

	
	@BeforeClass
	public void accPagesetUp() {
		accpage=lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@Description("This is AccountsPageUrl test ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void AccountsPageUrlTest() {
		String accPageUrl=accpage.getAccountPageUrl();
		System.out.println("The Account Page Url is "+ accPageUrl);
		Assert.assertEquals(accPageUrl, Constants.ACCOUNT_PAGE_URL_VALUE);
	}
	

	@Description("This is AccountsPagefooterText test ")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void footerTextTest() {
		String actualfooterText=accpage.footerText();
		System.out.println("Footer text is " + actualfooterText);
		Assert.assertTrue(actualfooterText.contains(Constants.ACCOUNT_PAGE_FOOTER_TEXT));
	}
	
	

	@Description("This is AccountsPageLinks test ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void getLinksListTest() {
	List<String> accLinks=	accpage.linksListdisplayed();
	System.out.println(accLinks);
	Assert.assertEquals(accLinks, Constants.EXP_LINKS_TEXT);
	
	}
	
	
}
