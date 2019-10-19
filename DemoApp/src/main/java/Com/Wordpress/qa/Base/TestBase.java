package Com.Wordpress.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.Wordpress.qa.Util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	TestUtil util;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\INSPIRON\\Desktop\\Myproject\\DemoApp\\src\\main\\java\\Com\\Wordpress\\qa\\Config\\config.properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

  
   public static void initialization()
   {
	   String browserName = prop.getProperty("browser");
	   if(browserName.equalsIgnoreCase("chrome"))
	   {
		
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	   }
	   else if(browserName.equalsIgnoreCase("firefox"))
	   {
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	   }
	   else if(browserName.equalsIgnoreCase("Edge"))
	   {
		System.setProperty("webdriver.edge.driver",".\\Drivers\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	   }
	   else
	   {
		   System.out.println("Driver not found");
	   }
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(TestUtil.Pageload_Timeout,TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Timeout, TimeUnit.SECONDS);
	   driver.get(prop.getProperty("url"));
	   
   }
         
}
