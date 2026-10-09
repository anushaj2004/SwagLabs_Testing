package ecom.SwagLabs_Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.PropertiesUtitlity;
import GenericUtitlity.ScreenshotUtility;
import ObjRepo.HomePage;
import ObjRepo.LoginPage;
import base.BaseClassForLogin;

public class TC_Login_Integration extends BaseClassForLogin {
	@Test(priority = 1, groups = {"integration","positive"})
	   public void tc_003() throws Exception
	   {
		   LoginPage l=new LoginPage(driver);
		   PropertiesUtitlity p=new PropertiesUtitlity();
		   l.loginDetails(p.readDatafromPropertyFileForLogin("un1"), p.readDatafromPropertyFileForLogin("password"));
		   Thread.sleep(2000);
		   Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"),"Product page is not displayed after sucessfull login");
	   }
	
	
}
