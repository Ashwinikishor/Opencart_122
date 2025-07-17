package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

@Test(groups= {"Sanity","Master"})
public void verify_login()
{
	logger.info("****Starting TC002_LoginPage***");
try {
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp= new LoginPage(driver);
	lp.setEmailAddress(p.getProperty("Email"));
	lp.setPassward(p.getProperty("password"));
	lp.clickLogin();
	
	MyAccountPage myacpg=new MyAccountPage(driver);
	boolean value= myacpg.isMyAccountPageExist();
	
	//Assert.assertEquals(value, true,"Login failed");
	Assert.assertTrue(value);
    }
catch(Exception e)
    {
		Assert.fail();
	}
	logger.info ("****Finished TC002_LoginTest*****");
}

}
