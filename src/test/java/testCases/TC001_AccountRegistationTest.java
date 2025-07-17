package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass{
     
   @Test(groups= {"Regression","Master"})
	public void verify_account_registration()
   {
	   logger.info("***Starting TC001_AccountRegistationTest*****");
	   
	   try
	   {
	   HomePage hp=new HomePage(driver);
	   hp.clickMyAccount();
	   logger.info("Clicked on MyAccount Link");
	   hp.clickRegister();
	   logger.info("Clicked on Register Link");
	   
	   RegisterAccountPage racpg=new RegisterAccountPage(driver);
	   
	   logger.info("Proving customer details");
	   racpg.setFirstName(randomeString().toUpperCase());
	   racpg.setLastName(randomeString().toUpperCase());
	   racpg.setEmailID(randomeString()+"@gmail.com");  //randomly generated the email
	   racpg.setTelephone(randomeNumber());
	   
	   String password=randomeAlphaNumeric();
	   
	   racpg.setPossword(password);
	   racpg.setPasswordConfirm(password);
	   racpg.Subscribe();
	   racpg.setPrivacyPolicy();
	   racpg.clickContinue();
	   
	   logger.info("Validating exectedresult");       

	   String cnfrmsg =racpg.getConfirmationMsg();
	  //System.out.println(cnfrmsg);
	   if(cnfrmsg.equals("Your Account Has Been Created!"))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   logger.error("Test failed");
		   Assert.assertTrue(true);
		   logger.debug("Debug logs");
		   Assert.assertTrue(false);
	   }
	   //Assert.assertEquals(cnfrmsg, "Your Account Has Been Created!");
	   }
	   catch(Exception e)
	   {
		      Assert.fail();
	   }
	   logger.info("***Finished TC001_AccountRegistationTest*** ");
   }
    
}
