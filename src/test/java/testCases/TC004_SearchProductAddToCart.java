package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
@Test
public class TC004_SearchProductAddToCart extends BaseClass {
	
	public void verify_Search()
	{
	logger.info("***Starting TC004_SearchProductAddToCart*****");
	
	try {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	logger.info(" clicked on Login");
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmailAddress(p.getProperty("Email"));
	lp.setPassward(p.getProperty("password"));
	lp.clickLogin();
	
	logger.info("Login Successfull");
	
	SearchPage sp=new SearchPage(driver);
	sp.enterSearch("macBook");
	sp.clickOnSearch();
	
		
	sp.clickOnMacBook();
	sp.addToCart();
	logger.info("Product Successfully Added to Cart");
	Assert.assertEquals(sp.isProductAddToCart(), true);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
}
}
