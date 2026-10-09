package ecom.SwagLabs_Checkout;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.ExcelUtility;
import GenericUtitlity.ScreenshotUtility;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage1;
import ObjRepo.CheckoutPage2;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Checkout_Negative extends BaseClass {
	@Test(priority=1 , groups ="functional")
	  public void tc_Negative1() throws InterruptedException, IOException {
		  ProductPage p=new ProductPage(driver);
			p.selectingSorting("Price (low to high)");
			p.getAddToCart(2);
			Thread.sleep(2000);
			HomePage h=new HomePage(driver);
			h.getCart();
			Thread.sleep(2000);
			CartPage c=new CartPage(driver);
			Thread.sleep(2000);
			c.getCheckoutbt();
			CheckoutPage1 c1=new CheckoutPage1(driver);
			ExcelUtility e=new ExcelUtility();
			e.openExcel();
			Thread.sleep(2000);
			String fn=e.getData("Sheet1", 1, 0);
			String ln=e.getData("Sheet1", 1, 1);
			String postalcode=e.getData("Sheet1", 1, 2).toString();
//			c1.getFirstName(fn);
			c1.getLastName(ln);
			c1.getPostalCode(postalcode);
			Thread.sleep(2000);
			c1.getContinuebt();
			ScreenshotUtility.takeScreenshot(driver, "TC_FirstNameBlank_Error");
			Thread.sleep(2000);
			String error=c1.getErrorMessage();
			Assert.assertEquals(error, "Error: First Name is required");
	  }
	
	
	
	@Test(priority=3 , groups ="system")
	public void tc_Negative3() throws InterruptedException, IOException {
		ProductPage p=new ProductPage(driver);
		p.getAddToCart(0);
		p.getAddToCart(1);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		c.getCheckoutbt();
		Thread.sleep(2000);
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
		Assert.assertTrue(c2.isCheckoutOverviewDisplayed(),"Checkout overview is not displayed");
		driver.navigate().back();
		Assert.assertTrue(c1.isCheckoutInformationDisplayed(),"Checkout Information page is not displayed after Browser Back");
		ScreenshotUtility.takeScreenshot(driver, "TC_BrowserBack_CheckoutInformation");
		
	}
	
	@Test(priority = 4,groups = "smoke")
	public void tc_Negative4() throws InterruptedException, IOException {
		ProductPage p=new ProductPage(driver);
		p.getAddToCart(0);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		c.getCheckoutbt();
		Thread.sleep(2000);
		CheckoutPage1 c1=new CheckoutPage1(driver);
		c1.getContinuebt();
		ScreenshotUtility.takeScreenshot(driver, "TC_AllFieldsBlank_Error");
		String actualError=c1.getErrorMessage();
		Assert.assertTrue(c1.isErrorDisplayed(),"Validation error is not displayed");
		//verify user remains on checkout information page
		Assert.assertTrue(c1.isCheckoutInformationDisplayed(),"Checkout Information page is not displayed");
	}
	
}
