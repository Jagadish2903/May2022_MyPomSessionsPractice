package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Epic( "Basic design of Accounts Page")
@Story("US102: Accounts check")

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	//By Locators
	private By product = By.xpath("//span[text()='Products']");
	private By links = By.xpath("//ul[@class='social']//a");
	private By footerText = By.xpath("//div[@class='footer_copy']");
	private By productBag=By.xpath("//div[text()='Sauce Labs Backpack']");
	
	//Constructors
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}

	//paghe actions
	
	public String getAccountPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isProductdisplayed() {
		return eleUtil.doIsDisplayed(product);
	}
	
	@Step("This is my AccountsPage footerText Step")
	public String footerText() {
		return eleUtil.getText(footerText);
	}
	
	@Step("This is my AccountsPage Links Step")
	public List<String> linksListdisplayed() {
	return	eleUtil.getListofElementsusingWaits(links, 5);
	}
	
	@Step("This is my AccountsPage Product Step")
	public ProductPage selectProduct(WebDriver driver) {
		eleUtil.doClick(productBag);
		return new ProductPage(driver);
	}
	
	
	

}
