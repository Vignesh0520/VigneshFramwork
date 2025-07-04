package pages.DemoAutomationTesting;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import base.BaseClass;
import pages.DemoAutomationTesting.Pojo.HomePage;
import pages.DemoAutomationTesting.Pojo.RegisterPage;

public class DATMainClass extends BaseClass {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		browserLaunch("chrome", "https://demo.automationtesting.in/Index.html");
		
		HomePage homePage = new HomePage(driver);
		homePage.getEmail().sendKeys("vigneshraja0520@gmail.com");
		screenshot("001_homePage", "C:\\Users\\vigne\\eclipse-workspace\\"
				+ "VigneshFramwork\\target\\DemoAutomationTestingPOMScreenshots\\");
		homePage.getButton().click(); 
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.getFirstName().sendKeys("Vignesh");
		registerPage.getLastName().sendKeys("Raja");
		String address = "3/282, Mariyamman Kovil Street, Manavalanallur, Eravanchery";
		registerPage.getAddress().sendKeys(address);
		registerPage.getEmail().sendKeys("vigneshraja0520@gmail.com");
		registerPage.getPhone().sendKeys("7094772888");
		registerPage.getGenderMale().click();
		registerPage.getHobbyCricket().click();
		registerPage.getHobbyMovies().click();
		registerPage.getHobbyHockey().click();
		registerPage.getLanguageList().click();
		staticWait(500);
		registerPage.getEnglishLanguage().click();
		registerPage.getHindiLanguage().click();
		WebElement skills = registerPage.getSkills();
		selectOptionByValue(skills, "Java");
		registerPage.getSelectCountry().click();
		registerPage.getSearchInCountryTextBox().sendKeys("india");
		registerPage.getCountryIndia().click();
		WebElement year = registerPage.getYear();
		selectOptionByValue(year, "2000");
		WebElement month = registerPage.getMonth();
		int index = 5; //May
		selectOptionByIndex(month, index);
		WebElement day = registerPage.getDay();
		selectOptionByValue(day, "20");
		registerPage.getPassword().sendKeys("Vignes@0");
		registerPage.getConfirmPassword().sendKeys("Vignes@0");
		scrollToTop();
		screenshot("002_registerPage", "C:\\Users\\vigne\\eclipse-workspace\\"
				+ "VigneshFramwork\\target\\DemoAutomationTestingPOMScreenshots\\");
		
		scrollToBottom();
		staticWait(250);
		screenshot("003_registerPage", "C:\\Users\\vigne\\eclipse-workspace\\"
				+ "VigneshFramwork\\target\\DemoAutomationTestingPOMScreenshots\\");
		registerPage.getSubmit().click();
		staticWait(1000);
		closeAllBrowserWindow();
	
	}
	
}
