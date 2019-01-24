package hooks;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import steps.CompareRetailFundsSteps;
import utilities.ReadCommandLineArguments;


//Cucumber feature binding file to perform setup and tear down
public class CucumberBindings {
	
	InputStream input;
	@Before
	public void initializeBrowser() throws IOException
	{
		//set up properties file
		Properties prop = new Properties();
		input = new FileInputStream("src/test/resources/config.properties");
		
		prop.load(input);
		
		//Reading command line arguments through Maven CLI
		ReadCommandLineArguments.readCMDArguments();
		
		//If browser argument is missing then choose Chrome browser
		if(ReadCommandLineArguments.browserName == null)
			ReadCommandLineArguments.browserName = prop.getProperty("browser");
		
		//Set up Chrome Browser
		if(ReadCommandLineArguments.browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			CompareRetailFundsSteps.driver = new ChromeDriver(options);
		}
		//Set up FireFox Browser
		else if(ReadCommandLineArguments.browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src/test/resources/Drivers/geckodriver.exe");
			CompareRetailFundsSteps.driver = new FirefoxDriver();
			
		}
				
		//maximize the browser window
		CompareRetailFundsSteps.driver.manage().window().maximize();
	
		//If command line url is not passed than select the homepage url
		if(ReadCommandLineArguments.url == null)
			ReadCommandLineArguments.url = prop.getProperty("url");
		
		//navigating to the URL
		CompareRetailFundsSteps.driver.get(ReadCommandLineArguments.url);
		
		//Setting implicit wait of 5 seconds
		CompareRetailFundsSteps.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	@After
	public void closeBrowser() throws IOException
	{
		//closing the browser
		CompareRetailFundsSteps.driver.quit();
		
		//closing the properties file
		if(input!=null)
			input.close();
	}
	 
}
