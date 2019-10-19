package Com.Wordpress.qa.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Wordpress.qa.Base.TestBase;
import Com.Wordpress.qa.pages.Homepage;
import Com.Wordpress.qa.pages.LoginPage;

public class HomepageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
    Logger log=Logger.getLogger(HomepageTest.class);
    
	public HomepageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setup()
	{   
		log.info("browser is starting");
		initialization();
		log.info("browser is opened");
		loginpage = new LoginPage();
		homepage = new Homepage();
		loginpage.Login(prop.getProperty("username"),prop.getProperty("pasword"));
		log.info("user entered username and data");
	}
	
	
	@Test
	public void SearchButtonDataTest() throws Exception
	{
		homepage.clickOnWrite();
		homepage.writeYourText("hi this is my program");
		homepage.clickOnPublish();
		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div/div/div/div[3]/div/div/div[1]/div/div/button")).click();
		log.info("your post is published");
		Thread.sleep(2000);	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
