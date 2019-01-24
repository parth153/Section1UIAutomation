package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page class for Home Page
public class HomePage {
	
	//local driver to work with elements
	WebDriver driver = null;
	
	//constructor to initialize driver
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Individual & SMSF investors Link Web element
	@FindBy(linkText="Individual & SMSF investors")
	WebElement individualAndSMSFInverstorsLink;
	
	//to click Individual & SMSF investors Web element
	public InvestmentsPage clickIndividualAndSMSFInverstorsLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(individualAndSMSFInverstorsLink));
		individualAndSMSFInverstorsLink.click();
		return new InvestmentsPage(driver); 
	}
}
