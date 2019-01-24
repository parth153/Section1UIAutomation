package pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Investments Page class
public class InvestmentsPage {
	
	//local driver to work with elements
	WebDriver driver = null;
	//constructor to initialize driver
	public InvestmentsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Fund compare link Web element
	@FindBy(linkText="Fund compare")
	WebElement fundscomparelink;
	
	//Click Fund compare and it opens two tabs so switching to the child tab
	public FundsCompare clickFundsCompare() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(fundscomparelink));
		fundscomparelink.click();
		
		//pausing the thread for 2 seconds for driver to find all handles
		//required for Firefox Browser
		Thread.sleep(2000);
		
		//switching driver to the new child tab
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		it.next();
		String child =it.next();
		driver.switchTo().window(child);
		return new FundsCompare(driver);
	}

}
