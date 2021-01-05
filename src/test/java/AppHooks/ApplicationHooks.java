package AppHooks;

import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.OutputType;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private WebDriver driver;
	private DriverFactory driverFactory;
	private Properties prop;
	private ConfigReader configReader;
	
	
	@Before(order=0)
	public void getproperty() {
		
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		
	}
	
	
	@Before(order=1)
	public void launchbrowser() {
		String browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browsername);
	}
	
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
	
		if(scenario.isFailed()) {
			//take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		
	}
	
	
}
