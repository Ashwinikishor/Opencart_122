package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

// Constructor
 public SearchPage (WebDriver driver)
 {
	super(driver);
 }
	
//Locator
	@FindBy(xpath="//input[@placeholder='Search']") 
	WebElement txt_search;
	@FindBy(xpath="//button[@type='button']")
	WebElement btn_search;	
	@FindBy(xpath="//h2[text()='Products meeting the search criteria']")
	WebElement msg_isProductExist;
	@FindBy(xpath="//a[text()='MacBook']")
	WebElement lnk_macBook;
	@FindBy(xpath="//button[@id='button-cart']") 
	WebElement btn_addToCart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement success_msg;
//Action Methods
	public void enterSearch(String search)
	{
		txt_search.sendKeys(search);
	}
	
	public void clickOnSearch()
	{
		btn_search.click();
	}

	 /*public boolean isProductExist()
	{
		try{
			return(msg_isProductExist.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}*/
	{
		lnk_macBook.click();
	}
	
	public void clickOnMacBook()
	{
		lnk_macBook.click();
	}
	public void addToCart()
	{
		btn_addToCart.click();
	}
	public boolean isProductAddToCart()
	{
		try{
			return(success_msg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}



