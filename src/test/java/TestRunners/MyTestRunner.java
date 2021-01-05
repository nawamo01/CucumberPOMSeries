package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"D:\\Core Java Training\\SeleniumSession\\CucumberPOMSeries\\src\\test\\resources\\AppFeatures\\LoginPage.feature"},
		glue = {"stepdefinitions","AppHooks"},
		plugin = {"pretty"}
		
		)


public class MyTestRunner {

}
