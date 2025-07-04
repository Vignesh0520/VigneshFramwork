package pages.DemoAutomationTesting.Pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='Skills']")
	private WebElement skills;
	
	@FindBy(xpath="//div[@class='ui-autocomplete-multiselect ui-state-default ui-widget']")
	private WebElement languageList;
	
	@FindBy(xpath="//a[text()='Hindi']")
	private WebElement englishLanguage;
	
	@FindBy(xpath="//a[text()='English']")
	private WebElement hindiLanguage;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@ng-model='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	private WebElement address;
	
	@FindBy(xpath="//input[@ng-model='Phone']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement genderMale;
	
	@FindBy(xpath="//input[@value='FeMale']")
	private WebElement genderFemale;
	
	@FindBy(xpath="//input[@value='Movies']")
	private WebElement hobbyMovies;
	
	@FindBy(xpath="//input[@value='Cricket']")
	private WebElement hobbyCricket;
	
	@FindBy(xpath="//input[@value='Hockey']")
	private WebElement hobbyHockey;
	
	@FindBy(xpath="//input[@ng-model='Password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@ng-model='CPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@ng-model='EmailAdress']")
	private WebElement email; 
	
	@FindBy(xpath="//span[@aria-labelledby='select2-country-container']")
	private WebElement selectCountry;
	
	@FindBy(xpath="//input[@class='select2-search__field' and @type='search']")
	private WebElement searchInCountryTextBox;
	
	@FindBy(xpath="//li[text()='India']")
	private WebElement countryIndia;
	
	@FindBy(xpath="//select[@id='yearbox']")
	private WebElement year;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='daybox']")
	private WebElement day;
	
	@FindBy(xpath="//button[text()=' Submit ']")
	private WebElement submit;
	
	public WebElement getYear() {
		return year;
	}
	public void setYear(WebElement year) {
		this.year = year;
	}
	public WebElement getMonth() {
		return month;
	}
	public void setMonth(WebElement month) {
		this.month = month;
	}
	public WebElement getDay() {
		return day;
	}
	public void setDay(WebElement day) {
		this.day = day;
	}
	public WebElement getEmail() {
		return email;
	}
	public void setEmail(WebElement email) {
		this.email = email;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public void setFirstName(WebElement firstName) {
		this.firstName = firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public void setLastName(WebElement lastName) {
		this.lastName = lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public void setAddress(WebElement address) {
		this.address = address;
	}
	public WebElement getPhone() {
		return phone;
	}
	public void setPhone(WebElement phone) {
		this.phone = phone;
	}
	public WebElement getGenderMale() {
		return genderMale;
	}
	public void setGenderMale(WebElement genderMale) {
		this.genderMale = genderMale;
	}
	public WebElement getGenderFemale() {
		return genderFemale;
	}
	public void setGenderFemale(WebElement genderFemale) {
		this.genderFemale = genderFemale;
	}
	public WebElement getHobbyMovies() {
		return hobbyMovies;
	}
	public void setHobbyMovies(WebElement hobbyMovies) {
		this.hobbyMovies = hobbyMovies;
	}
	public WebElement getHobbyCricket() {
		return hobbyCricket;
	}
	public void setHobbyCricket(WebElement hobbyCricket) {
		this.hobbyCricket = hobbyCricket;
	}
	public WebElement getHobbyHockey() {
		return hobbyHockey;
	}
	public void setHobbyHockey(WebElement hobbyHockey) {
		this.hobbyHockey = hobbyHockey;
	}
	public WebElement getPassword() {
		return password;
	}
	public void setPassword(WebElement password) {
		this.password = password;
	}
	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(WebElement confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public WebElement getLanguageList() {
		return languageList;
	}
	public void setLanguageList(WebElement languageList) {
		this.languageList = languageList;
	}
	public WebElement getEnglishLanguage() {
		return englishLanguage;
	}
	public void setEnglishLanguage(WebElement englishLanguage) {
		this.englishLanguage = englishLanguage;
	}
	public WebElement getHindiLanguage() {
		return hindiLanguage;
	}
	public void setHindiLanguage(WebElement hindiLanguage) {
		this.hindiLanguage = hindiLanguage;
	}
	public WebElement getSkills() {
		return skills;
	}
	public void setSkills(WebElement skills) {
		this.skills = skills;
	}
	public WebElement getSelectCountry() {
		return selectCountry;
	}
	public void setSelectCountry(WebElement selectCountry) {
		this.selectCountry = selectCountry;
	}
	public WebElement getSearchInCountryTextBox() {
		return searchInCountryTextBox;
	}
	public void setSearchInCountryTextBox(WebElement searchInCountryTextBox) {
		this.searchInCountryTextBox = searchInCountryTextBox;
	}
	public WebElement getCountryIndia() {
		return countryIndia;
	}
	public void setCountryIndia(WebElement countryIndia) {
		this.countryIndia = countryIndia;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	

}
