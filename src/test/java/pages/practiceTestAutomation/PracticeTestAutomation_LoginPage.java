package pages.practiceTestAutomation;

import java.io.IOException;

import base.BaseClass;

public class PracticeTestAutomation_LoginPage extends BaseClass {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Launch the browser with given browser type and URL
		browserLaunch("chrome", "https://practicetestautomation.com/practice-test-login/");
		
		// Define the path to the Excel file containing test data
		String filePath = "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork\\src\\test\\resources"
				+ "\\PracticeTestAutomation_LoginPage_Data.xlsx";
		
		// Call the test method to perform data-driven login tests
		test_PracticeTestAutomation_LoginPage(filePath);
		
		closeAllBrowserWindow();
		
	}

}
