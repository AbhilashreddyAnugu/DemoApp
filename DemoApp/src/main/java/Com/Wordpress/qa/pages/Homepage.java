package Com.Wordpress.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Wordpress.qa.Base.TestBase;
import Com.Wordpress.qa.Util.TestUtil;

public class Homepage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Write')]")
	WebElement WriteAnydata;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
     
	
	/*public void Mysearch()
	{
		WebElement e;
    	WebDriverWait wait= new WebDriverWait(driver,30);
    	e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/read/search']")));
    	e.click();
	}*/
	
	public void clickOnWrite()
	{
		WriteAnydata.click();	
	}
	public void writeYourText(String str)
	{
		TestUtil.Frame();
		driver.findElement(By.xpath("//*[@id=\"post-title-0\"]")).sendKeys(str);
	}
	
	public void clickOnPublish()
	{
		driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div/div[1]/div[2]/div[1]/button")).click();
	}
     
}
