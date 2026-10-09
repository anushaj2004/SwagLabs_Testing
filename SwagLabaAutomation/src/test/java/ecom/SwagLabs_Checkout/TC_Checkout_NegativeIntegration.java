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

public class TC_Checkout_NegativeIntegration extends BaseClass {
	@Test(priority=2 , groups ="Integration")
	public void tc_Negative2() throws InterruptedException, IOException
	{
		ProductPage p=new ProductPage(driver);
		p.getAddToCart(0);
		p.getAddToCart(1);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		Assert.assertEquals(c.getProductCount(), 2,"Two products are not present in Cart");
		c.getRemoveBt(0);
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
		ScreenshotUtility.takeScreenshot(driver, "TC_ProductRemoved_FromCart");
		Assert.assertEquals(c2.getProductCount(),1, "Removed product was incorrectly transferred to Checkout");
		System.out.println("Removed product was not transferred to checkout");
	}
}
