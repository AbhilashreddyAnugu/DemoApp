package Com.Wordpress.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Wordpress.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="navbar-login-link")
	WebElement loginlink;
	
	@FindBy(id="usernameOrEmail")
	WebElement username;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement continueLink;
	
	/*@FindBy(id="password")
	WebElement password;*/
	
	@FindBy(xpath="//button[text()='Log In']")
	WebElement loginbtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
     
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public void Login(String uname,String pwd)
	{
		loginlink.click();
		username.sendKeys(uname);
		continueLink.click();
		WebElement e;
    	WebDriverWait wait= new WebDriverWait(driver,30);
    	e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    	e.sendKeys(pwd);
		loginbtn.click();
		
	}

	

}
