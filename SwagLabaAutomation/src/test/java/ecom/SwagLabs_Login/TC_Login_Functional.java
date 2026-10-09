package ecom.SwagLabs_Login;



import org.testng.annotations.Test;

import GenericUtitlity.PropertiesUtitlity;

import ObjRepo.HomePage;
import ObjRepo.LoginPage;
import base.BaseClassForLogin;

public class TC_Login_Functional extends BaseClassForLogin {
   @Test(priority = 1, groups = "functional")
   public void tc_001() throws Exception
   {
	   LoginPage l=new LoginPage(driver);
	   PropertiesUtitlity p=new PropertiesUtitlity();
	   l.loginDetails(p.readDatafromPropertyFileForLogin("un1"), p.readDatafromPropertyFileForLogin("password"));
	   Thread.sleep(2000);
	   HomePage h=new HomePage(driver);
		h.getHamburger();
		Thread.sleep(2000);
		h.getLogout();
		System.out.println("logout executed");
   }
}
