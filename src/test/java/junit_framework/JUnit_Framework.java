package junit_framework;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import pages.practiceTestAutomation.pojo.PTA_LoginPage;

public class JUnit_Framework extends BaseClass {

	PTA_LoginPage pTA_LoginPage;

	@BeforeClass
	public static void testInitilization() {
		System.out.println("\nUnit test got initialized");
	}

	@Before
	public void browserLaunch() {
		browserLaunch("chrome", "https://practicetestautomation.com/practice-test-login/");
		System.out.println("Browser Launched");
	}

	@Test
	public void testCase1() throws InterruptedException {
		pTA_LoginPage = new PTA_LoginPage(driver);
		scrollIntoViewTrue(pTA_LoginPage.getUsernameLabel());
		pTA_LoginPage.getUserName().sendKeys("student");
		pTA_LoginPage.getPassword().sendKeys("Password123");
		staticWait(250);
		pTA_LoginPage.getSubmitBtn().click();
		String actualCurrentUrl = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://practicetestautomation.com/logged-in-successfully/";
		Assert.assertEquals(expectedCurrentUrl, actualCurrentUrl);	
		System.out.println("Validated TestCase 1");
	}

	@Test
	public void testCase2() throws InterruptedException {
		pTA_LoginPage = new PTA_LoginPage(driver);
		scrollIntoViewTrue(pTA_LoginPage.getUsernameLabel());
		pTA_LoginPage.getUserName().sendKeys("incorrectUser");
		pTA_LoginPage.getPassword().sendKeys("Password123");
		staticWait(250);
		pTA_LoginPage.getSubmitBtn().click();
		String actualCurrentUrl = driver.getCurrentUrl();
		String expectedCurrentUrl = "https://practicetestautomation.com/logged-in-successfully/";
		boolean equals = actualCurrentUrl.equals(expectedCurrentUrl);
		Assert.assertFalse(equals);
		System.out.println("Validated TestCase 2");
	}

	@Test
	public void testCase3() throws InterruptedException {
		pTA_LoginPage = new PTA_LoginPage(driver);
		scrollIntoViewTrue(pTA_LoginPage.getUsernameLabel());
		pTA_LoginPage.getUserName().sendKeys("student");
		pTA_LoginPage.getPassword().sendKeys("incorrectPassword");
		staticWait(250);
		pTA_LoginPage.getSubmitBtn().click();
		staticWait(250);
		WebElement error_message = findElementByXpath("//div[text()='Your password is invalid!']");
		boolean displayed = error_message.isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("Validated TestCase 3");
		
	}

	@After
	public void closeBrowser() {
		closeAllBrowserWindow();
		System.out.println("Browser Closed");
	}

	@AfterClass
	public static void testExit() {
		System.out.println("Unit test got completed\n");
	}

}
