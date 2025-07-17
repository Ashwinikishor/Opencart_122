package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProvider.class,groups="Datadriven") //getting data provider from different class and different package
public void verify_loginDDT(String email, String passwd, String exp) throws InterruptedException
	{
		logger.info("******Strating TC003_LoginDDT***");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp= new LoginPage(driver);
		lp.setEmailAddress(email);
		lp.setPassward(passwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage myacpg=new MyAccountPage(driver);
		boolean actvalue= myacpg.isMyAccountPageExist();
		
		/* Data is valid -login is success -test pass -logout 
		                 -login is unsuccess -test fail 
		 
		 Data is invalid -login success -test fail -logout
		                 -login unsuccess -test pass  */
		  
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(actvalue==true)
			{
				
				myacpg.Logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);	
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(actvalue==true)
			{
				myacpg.Logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);	
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("******Finished TC003_LoginDDT***");
		}
	}
	
	
	

