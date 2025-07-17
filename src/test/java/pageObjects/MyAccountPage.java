package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msg_myAccount;
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement lnk_logout;
	
	
	public boolean isMyAccountPageExist()
	{
		try{
			return(msg_myAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void Logout()
	{
		lnk_logout.click();
	}
	
}
