package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	/*
	 * This method is used to initialize the Thread Local driver on the basis of given browser
	 * Theadlocal is used for parallel execution
	 */

	public WebDriver init_driver(String browser) {
		System.out.println("The browser value is : " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new FirefoxDriver());
		}

		else if (browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("Please enter the correct browser name : " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	
	/*This method is used to get the driver with Thread Local
	 * Synchronized keyword used for parallel execution
	*/
	public static synchronized WebDriver getDriver() {

		return tldriver.get();

	}

}
