package Com.Wordpress.qa.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.Wordpress.qa.Base.TestBase;

public class TestUtil extends TestBase{
	
	TestUtil util;
	
	public static long Pageload_Timeout=30;
	public static long Implicit_Timeout=30;
	
	public TestUtil()
	{
		super();
	}
	
	public static void Frame()
	{
		WebElement frame=driver.findElement(By.xpath("//iframe[@src='https://example300601792.wordpress.com/wp-admin/post-new.php?calypsoify=1&block-editor=1&frame-nonce=63350d0a07&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user=&_support_token=']"));
		driver.switchTo().frame(frame);
	}
}
