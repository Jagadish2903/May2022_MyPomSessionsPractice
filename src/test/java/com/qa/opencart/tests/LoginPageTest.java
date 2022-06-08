package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic( "Basic design of Login Page")
@Story("US101: Login Functionality check")
public class LoginPageTest extends BaseTest {

	
	@Description("This is LoginTitle test ")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void doPageTitleTest() {
	String title=lp.getPageTitle();
	Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	
	@Description("This is LoginUrl test ")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void doPageUrlTest() {
	   String actualurl=lp.getPageUrl();
	   Assert.assertTrue(actualurl.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}
	
	
	@Description("This is LoginTitle test ")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		lp.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

}
