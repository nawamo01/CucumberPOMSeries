package stepdefinitions;


import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinition {

	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {

DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	title = loginpage.getLoginPageTitle();
System.out.println("The Page title is : "+title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		Assert.assertEquals(title, expectedTitle, "Title not matched");
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		Assert.assertTrue(loginpage.isForgotpwdLinkExist());
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) {
		loginpage.enterUserName(username);
		
	}

	@When("user enters the passowrd {string}")
	public void user_enters_the_passowrd(String pwd) {
loginpage.enterPassword(pwd);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
loginpage.clickOnLoginButton();

	}

	
}
