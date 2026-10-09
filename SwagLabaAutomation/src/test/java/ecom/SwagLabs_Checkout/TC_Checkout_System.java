package ecom.SwagLabs_Checkout;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtitlity.ExcelUtility;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage1;
import ObjRepo.CheckoutPage2;
import ObjRepo.CheckoutPage3;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Checkout_System extends BaseClass{
@Test(priority = 5, groups = "system")
public void tc_005() throws InterruptedException, IOException {
	
	ProductPage p=new ProductPage(driver);
	p.selectingSorting("Price (low to high)");
	p.getAddToCart(0);
	Thread.sleep(2000);
	HomePage h=new HomePage(driver);
	h.getCart();
	Thread.sleep(2000);
	CartPage c=new CartPage(driver);
	c.getCheckoutbt();
	CheckoutPage1 c1=new CheckoutPage1(driver);
	ExcelUtility e=new ExcelUtility();
	e.openExcel();
	Thread.sleep(2000);
	String fn=e.getData("Sheet1", 1, 0);
	String ln=e.getData("Sheet1", 1, 1);
	String postalcode=e.getData("Sheet1", 1, 2).toString();
	c1.getFirstName(fn);
	c1.getLastName(ln);
	c1.getPostalCode(postalcode);
	Thread.sleep(2000);
	c1.getContinuebt();
	CheckoutPage2 c2=new CheckoutPage2(driver);
	c2.getFinishBt();
	CheckoutPage3 c3=new CheckoutPage3(driver);
	String actualMessage=c3.getConfirmationMessage();
	Reporter.log(actualMessage,true);
	Assert.assertEquals(actualMessage, "Thank you for your order!");
}

   @Test(priority = 6, groups = "system")
   public void tc_006() throws InterruptedException, IOException {
	   ProductPage p=new ProductPage(driver);
		p.selectingSorting("Price (low to high)");
		p.getAddToCart(1);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		c.getCheckoutbt();
		CheckoutPage1 c1=new CheckoutPage1(driver);
		ExcelUtility e=new ExcelUtility();
		e.openExcel();
		Thread.sleep(2000);
		String fn=e.getData("Sheet1", 1, 0);
		String ln=e.getData("Sheet1", 1, 1);
		String postalcode=e.getData("Sheet1", 1, 2).toString();
		c1.getFirstName(fn);
		c1.getLastName(ln);
		c1.getPostalCode(postalcode);
		Thread.sleep(2000);
		c1.getContinuebt();
		//verify checkout overview
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"),"Checkout Overview page was not displayed");
		CheckoutPage2 c2=new CheckoutPage2(driver);
		c2.getCancel();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "User was not returned to the Products page after cancel");
   }

}
