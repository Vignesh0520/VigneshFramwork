package pages.amazon.pojo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon {

	public Amazon(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search Amazon.in']")
	private WebElement search;

	@FindBy(xpath = "//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']/span")
	private List<WebElement> productNames;

	@FindBy(xpath = "//a[@aria-describedby='price-link']//span[@class='a-price-whole']")
	private List<WebElement> prices;

	public WebElement getSearch() {
		return search;
	}

	public void setSearch(WebElement search) {
		this.search = search;
	}

	public List<WebElement> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<WebElement> productNames) {
		this.productNames = productNames;
	}

	public List<WebElement> getPrices() {
		return prices;
	}

	public void setPrices(List<WebElement> prices) {
		this.prices = prices;
	}

}
