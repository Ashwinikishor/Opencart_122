package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

//Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

//WebElement
@FindBy(xpath="//input[@id='input-email']")
WebElement txt_eMailAddress;
@FindBy(xpath="//input[@id='input-password']")
WebElement txt_password;
@FindBy(xpath="//input[@value='Login']")
WebElement lnk_login;

//Action Methods
public void setEmailAddress(String email)
{
	txt_eMailAddress.sendKeys(email);
}

public void setPassward(String pswd)
{
	txt_password.sendKeys(pswd);
}
public void clickLogin()
{
	lnk_login.click();
}

}