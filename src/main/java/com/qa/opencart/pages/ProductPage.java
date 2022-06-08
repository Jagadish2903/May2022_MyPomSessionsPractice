package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;



@Epic( "Basic design of Product Page")
@Story("US103: Product Functionality check")

public class ProductPage {
	
	

	private WebDriver driver;
	private ElementUtil eleUtil;
	// By locators
	private By productText = By.xpath("//div[text()='Sauce Labs Backpack']");
	private By description = By.xpath("//div[@class='inventory_details_desc large_size']");
	private By addtoCart = By.id("add-to-cart-sauce-labs-backpack");

	// Constructors
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	@Step("This is my ProductPagecheck Item Step")
	public String checkProduct() {
		 return eleUtil.getText(productText);	
	}
	
	@Step("This is my ProductPage addToCartBtn Step")
	public boolean isaddToCartEnabled() {
		return eleUtil.doISEnabled(addtoCart);
	}
	
	@Step("This is my ProductPage description Step")
	public boolean isProductDescriptiondisplayed() {
		return eleUtil.doIsDisplayed(description);
	}
	
	
}
