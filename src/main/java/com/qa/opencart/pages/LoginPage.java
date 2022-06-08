package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Epic( "Basic design of Login Page")
@Story("US101: Login Functionality check")
public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	
	//By locators
	private By emaild = By.id("user-name");
	private By password = By.id("password");
	private By loginbtn = By.id("login-button");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	
	//Pageactions
	@Step("This is my LoginPage Title Step")
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@Step("This is my LoginPage URL Step")
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	
	
	public AccountsPage doLogin(String un,String pwd) {
		eleUtil.doSendKeys(emaild, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginbtn);
		return new AccountsPage(driver)	;	
		
	}
}
