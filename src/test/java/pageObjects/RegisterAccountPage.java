package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends BasePage {

//constructor
	public RegisterAccountPage (WebDriver driver)
	{
		super(driver);
	}
	
//WebElement	

@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txt_firstName;
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txt_lastName;
@FindBy(xpath="//input[@id='input-email']") 
WebElement txt_eMail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txt_telephone;
@FindBy(xpath="//input[@id='input-password']") 
WebElement txt_password;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txt_passwordConfirm;
@FindBy(xpath="//input[@value='0']")
WebElement btn_newsletter;
@FindBy(xpath="//input[@name='agree']")
WebElement chk_agree;
@FindBy(xpath="//input[@value='Continue']")
WebElement btn_continue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

//Action methods

public void setFirstName(String firstname)
{
	txt_firstName.sendKeys(firstname);
}
public void setLastName(String lasttname)
{
	txt_lastName.sendKeys(lasttname);
}
public void setEmailID(String email)
{
	txt_eMail.sendKeys(email);
}
public void setTelephone(String telephone)
{
	txt_telephone.sendKeys(telephone);
}
public void setPossword(String possword)
{
	txt_password.sendKeys(possword);
}
public void setPasswordConfirm(String password)
{
	txt_passwordConfirm.sendKeys(password);
}
public void Subscribe()
{
	btn_newsletter.click();
}
public void setPrivacyPolicy()
{
	chk_agree.click();
}
public void clickContinue()
{
	//soln 1
	btn_continue.click();
	
/* //soln2 using submit
	btn_continue.submit();
	
	//soln3 using Action class
	Actions act= new Actions(driver);
	act.moveToElement(btn_continue).click().perform();
	
	//soln4 JAvascript exicutor
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguements[0].click();",btn_continue);
	
	//soln5
	btn_continue.sendKeys(Keys.RETURN);
	
	//soln6 using Exclicit wait
	WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	mywait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
	*/
}
 public String getConfirmationMsg()
 {
	 try {
		 return(msgConfirmation.getText());
	     }
	 catch(Exception e) {
		return (e.getMessage()) ;
	 }
 }
}
