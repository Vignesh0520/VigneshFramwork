package pages.DemoAutomationTesting;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import base.BaseClass;

//PageClass
public class DATRegisterPage extends BaseClass {
	
public static void main(String[] args) throws InterruptedException, IOException {
		
		browserLaunch("chrome", "https://demo.automationtesting.in/Register.html");
		refresh();
		implicitlyWait("seconds", 15);
		WebElement firstName = findElementByXpath("//input[@placeholder='First Name']");
		WaitForElementVisibility(firstName, 10);
		
		screenshot("RegisterPage_BeforeInPut_001", "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
				+ "\\target\\DemoAutomationTestingRegisterScreenshots\\");
		scrollToBottom();
		staticWait(250);
		screenshot("RegisterPage_BeforeInPut_002", "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
				+ "\\target\\DemoAutomationTestingRegisterScreenshots\\");
		scrollToTop();
		
		textboxInput(firstName, "Vignesh");
		
		WebElement lastName = findElementByXpath("//input[@ng-model='LastName' and @type='text']");
		textboxInput(lastName, "Raja");
		
		WebElement address = findElementByXpath("//textarea[@ng-model='Adress']");
		String addressDetail = "3/282, Mariyamman kovil street, Manavalanallur, "
				+ "Eravancheri(Post), Kudavasal(Taluk), Thiruvarur(District), TamilNadu, India - 609 501";
		textboxInput(address, addressDetail);
		
		WebElement email = findElementByXpath("//input[@ng-model='EmailAdress' or @type='email']");
		textboxInput(email, "vigneshraja0520@gmail.com");
		
		WebElement phone = findElementByXpath("//label[text()='Phone*']/following-sibling::div//input[@type = 'tel']");
		textboxInput(phone, "7094772888");
		
		WebElement gender = findElementByXpath("//input[@type='radio' and @value='Male']");
		gender.click();
		
		WebElement hobbyCricket = findElementByCssSelector("input[value='Cricket']");
		hobbyCricket.click();
		
		WebElement hobbyMovies = findElementByCssSelector("[value='Movies']");
		hobbyMovies.click();
		
		WebElement hobbyHockey = findElementByCssSelector("#checkbox3");
		hobbyHockey.click();
		
		WebElement languageList = findElementByXpath("//div[@class='ui-autocomplete-multiselect "
				+ "ui-state-default ui-widget']");
		languageList.click();
		
		staticWait(1000);
		
		WebElement englishLanguage = findElementByXpath("//a[text()='English']");
		englishLanguage.click();
		
		WebElement hindiLanguage = findElementByXpath("//a[text()='Hindi']");
		hindiLanguage.click();
		
		WebElement skills = findElementByXpath("//select[@id='Skills']");
		selectOptionByValue(skills, "Java");
		
		WebElement selectCountry = findElementByXpath("//span[@aria-labelledby='select2-country-container']");
		selectCountry.click();
		
		//input[@class='select2-search__field' and @type='search']
		WebElement searchInCountryTextBox = findElementByXpath("//input[@class='select2-search__field' and @type='search']");
		textboxInput(searchInCountryTextBox, "india");
		staticWait(200);
		
		WebElement india = findElementByXpath("//li[text()='India']");
		india.click();
		
		WebElement year = findElementByXpath("//select[@id='yearbox']");
		selectOptionByValue(year, "2000");
		
		WebElement month = findElementByXpath("//select[@placeholder='Month']");
		int index = 5; //May
		selectOptionByIndex(month, index);
		
		WebElement day = findElementByXpath("//select[@id='daybox']");
		selectOptionByValue(day, "20");
		
		WebElement password = findElementByCssSelector("[ng-model='Password']");
		textboxInput(password, "Vignes@0");
		
		WebElement confirmPassword = findElementByCssSelector("[ng-model='CPassword']");
		textboxInput(confirmPassword, "Vignes@0");
		
		scrollToTop();
		screenshot("RegisterPage_AfterInPut_001", "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
				+ "\\target\\DemoAutomationTestingRegisterScreenshots\\");
		
		scrollToBottom();
		staticWait(250);
		screenshot("RegisterPage_AfterInPut_002", "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
				+ "\\target\\DemoAutomationTestingRegisterScreenshots\\");
			
		WebElement submitBtn = findElementByXpath("//button[text()=' Submit ']");
		submitBtn.click();
		staticWait(1000);
		
		closeAllBrowserWindow();
		
	}

}
