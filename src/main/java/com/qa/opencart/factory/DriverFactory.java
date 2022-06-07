package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager optionmanager;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	
	public WebDriver initBrowser(Properties prop) {
		
		optionmanager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight");

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionmanager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionmanager.getChromeOptions()));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionmanager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionmanager.getFirefoxOptions()));
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please Pass Correct browser");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	
	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties initProp() {
		prop = new Properties();
		FileInputStream ip = null;

		String env = System.getProperty("env");

		if (env == null) {
			try {
				ip = new FileInputStream("./src/resource/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} 
		try {
			switch (env.toLowerCase()) {
			case "qa":
				ip = new FileInputStream("./src/resource/config/config.properties");
					break;
			case "Stage":
				ip = new FileInputStream("stage path++___");
				break;
			case "Prod":
				ip = new FileInputStream("Prod Path++++");
				break;
			default:
				System.out.println("Please Pass the Correct Env Name " + env);
				break;
			}
		}
	catch(Exception e) {
				e.printStackTrace();
			}
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return prop;
	
	}
	
	/**
	 * this method is used to take screenshots
	 */
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	

}
