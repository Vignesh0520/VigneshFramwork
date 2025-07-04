package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.amazon.pojo.Amazon;
import pages.practiceTestAutomation.pojo.PTA_LoginPage;

public class BaseClass {

	public static WebDriver driver;

	public static Actions action;

	public static Select select;

	public static JavascriptExecutor jsExecutor;

	// Browser Launch
	public static void browserLaunch(String BrowserName, String url) {

		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	// scrollIntoView(true)
	public static void scrollIntoViewTrue(WebElement element) {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// Static Wait - Thread.sleep()
	public static void staticWait(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	// locate the element using xpath
	public static WebElement findElementByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}

	// Quit()
	public static void closeAllBrowserWindow() {
		driver.quit();
	}

	// --> Open Amazon India and search for the given product
	// --> Save the product names and prices to an Excel sheet
	public static void DDF_storeAmazonResultInExcel(String productName, String sheetName, String excelFileName)
			throws IOException {

		// Launches the browser and navigates to Amazon India site
		browserLaunch("chrome", "https://www.amazon.in/");

		// Initializes the Amazon Page Object Model (POM) class
		Amazon amazon = new Amazon(driver);

		// Enters the product name in the search box and presses ENTER
		WebElement amazonSearch = amazon.getSearch();
		amazonSearch.sendKeys(productName + Keys.ENTER);

		// Fetches the list of product names displayed on the search result page
		List<WebElement> productNames = amazon.getProductNames();

		// Fetches the corresponding prices of the products
		List<WebElement> prices = amazon.getPrices();

		// Creates a FileOutputStream pointing to the Excel file path where data will be
		// written
		FileOutputStream fos = new FileOutputStream("C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
				+ "\\src\\test\\resources\\" + excelFileName + ".xlsx");

		// Creates a new workbook (XSSFWorkbook for .xlsx format)
		Workbook workbook = new XSSFWorkbook();

		// Creates a sheet in the workbook named "Product_and_Price"
		Sheet sheet = workbook.createSheet(sheetName);

		// Iterates through both productNames and prices lists
		for (int i = 0; (i < productNames.size() & i < prices.size()); i++) {

			// Creates a new row for each product-price pair
			Row row = sheet.createRow(i);

			// Loops to create two cells in each row: one for product, one for price
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					// Creates first cell and stores the product name
					Cell cell = row.createCell(j);
					String product = productNames.get(i).getText();
					cell.setCellValue(product);
				} else if (j == 1) {
					// Creates second cell and stores the product price
					Cell cell = row.createCell(j);
					String price = prices.get(i).getText();
					cell.setCellValue(price);
				}
			}

		}

		// Writes the workbook data into the Excel file
		workbook.write(fos);

		// Closes the workbook and file stream
		workbook.close();
		fos.close();

		// Closes all browser windows after operation is complete
		closeAllBrowserWindow();

	}

	// --> https://practicetestautomation.com/practice-test-login/
	// --> Login page testing using Data Driven Framework - Read from Excel
	public static void test_PracticeTestAutomation_LoginPage(String inputDataFilePath)
			throws IOException, InterruptedException {

		// Load the Excel file using FileInputStream
		FileInputStream fileInputStream = new FileInputStream(inputDataFilePath);

		// Create Workbook instance from the Excel file
		Workbook workbook = new XSSFWorkbook(fileInputStream);

		// Access the specific sheet that contains login credentials
		Sheet sheet = workbook.getSheet("UserName_Password");

		// Iterate through all rows (each row represents a username/password
		// combination)
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

			// Initialize Page Object for the login page
			PTA_LoginPage pTA_LoginPage = new PTA_LoginPage(driver);

			// Get the WebElements for username, password, and username label
			WebElement userName = pTA_LoginPage.getUserName();
			WebElement password = pTA_LoginPage.getPassword();
			WebElement usernameLabel = pTA_LoginPage.getUsernameLabel();

			// Scroll to the username label to ensure it's visible before interaction
			scrollIntoViewTrue(usernameLabel);

			// Get the current row from the sheet
			Row row = sheet.getRow(i);

			// Iterate through each cell in the row
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {

				// Get the current cell
				Cell cell = row.getCell(j);

				// If it's the first cell, treat it as username
				if (j == 0) {
					String user = cell.getStringCellValue();
					userName.sendKeys(user);
				}

				// If it's the second cell, treat it as password
				else if (j == 1) {
					String pass = cell.getStringCellValue();
					password.sendKeys(pass);
				}
			}

			// Capture a screenshot before clicking the submit button
			WebElement submitBtn = pTA_LoginPage.getSubmitBtn();
			screenshot("00" + i + "_PTA_LoginPage", "C:\\Users\\vigne\\eclipse-workspace\\VigneshFramwork"
					+ "\\target\\DDF_PracticeTestAutomation_LoginPage_Screenshots\\");

			// Click the submit button to perform loginF
			submitBtn.click();

			staticWait(500);

		}

		// Close the workbook to release resources
		workbook.close();
	}

	// Close()
	public static void closeCurrentBrowserWindow() {
		driver.close();
	}

	// Implicitly Wait
	public static void implicitlyWait(String unit, int quantity) {

		if (unit.equalsIgnoreCase("seconds")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(quantity));
		} else if (unit.equalsIgnoreCase("minutes")) {
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(quantity));
		}

	}

	// Refreshes the Browser
	public static void refresh() {
		driver.navigate().refresh();
	}

	// locate the element using cssSelector
	public static WebElement findElementByCssSelector(String cssSelector) {

		WebElement element = driver.findElement(By.cssSelector(cssSelector));
		return element;

	}

	// Mouse hover action
	public static void moveMouseToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	// sendKeys()
	public static void textboxInput(WebElement element, String input) {

		element.sendKeys(input);

	}

	// Select by value
	public static void selectOptionByValue(WebElement element, String value) {

		select = new Select(element);
		boolean multiple = select.isMultiple();
		if (multiple == true) {
			System.out.println("Given Select is Multiselect");
		}
		select.selectByValue(value);

	}

	// Select by Index
	public static void selectOptionByIndex(WebElement element, int index) {

		select = new Select(element);
		boolean multiple = select.isMultiple();
		if (multiple == true) {
			System.out.println("Given Select is Multiselect");
		}
		select.selectByIndex(index);

	}

	// Screenshot
	public static void screenshot(String fileName, String filePath) throws IOException {

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePath + fileName + ".png");
		FileUtils.copyFile(src, dest);
	}

	// Scrolls to Bottom of the page
	public static void scrollToBottom() {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	// Scrolls to Top of the page
	public static void scrollToTop() {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, 0);");

	}

	// scrollIntoView(false)
	public static void scrollIntoViewFalse(WebElement element) {

		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", element);

	}

	// WebDriverWait
	public static void WaitForElementVisibility(WebElement element, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
