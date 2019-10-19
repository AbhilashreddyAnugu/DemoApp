package Com.Wordpress.qa.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Wordpress.qa.Base.TestBase;
import Com.Wordpress.qa.pages.LoginPage;

public class LoginpageTest extends TestBase{
	LoginPage loginpage;
	
	
	public LoginpageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void validateTestTitle()
	{
		String title=loginpage.validateTitle();
		Assert.assertEquals(title, "WordPress.com: Create a Free Website or Blog");
	}
	
	@Test(priority=2)
	public void logintest()
	{
		loginpage.Login(prop.getProperty("username"),prop.getProperty("pasword"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
