package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
//Locator

@FindBy(xpath="//a[@title='My Account']") 
WebElement lnk_myAccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnk_register;


@FindBy(xpath="//a[normalize-space()='Login']")
WebElement lnk_login;
	
//Action Methods
public void clickMyAccount() 
{
	lnk_myAccount.click();
}
 public void clickRegister()
 {
	 lnk_register.click(); 
 }

 public void clickLogin()
 {
	 lnk_login.click(); 
 }

}
