package ecom.SwagLabs_Checkout;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.ExcelUtility;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage1;
import ObjRepo.CheckoutPage2;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Checkout_Integration extends BaseClass {

	@Test(priority = 3, groups = "integration")
	public void tc_003() throws IOException, InterruptedException
	{
		ProductPage p=new ProductPage(driver);
		p.selectingSorting("Price (low to high)");
		p.getAddToCart(0);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		String cartProduct=c.getProductItem(0);
		Thread.sleep(2000);
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
		String overviewProduct=c2.getProductItem(0);
		Thread.sleep(2000);
		Assert.assertEquals(overviewProduct,cartProduct,"Product in checkout overview doesnot match the product in Cart" );
	}
	
	@Test(priority = 4, groups = "integration")
	public void tc_004() throws InterruptedException, IOException {
		ProductPage p=new ProductPage(driver);
		p.selectingSorting("Price (low to high)");
		p.getAddToCart(1);
		Thread.sleep(2000);
		HomePage h=new HomePage(driver);
		h.getCart();
		Thread.sleep(2000);
		CartPage c=new CartPage(driver);
		String product1=c.getProductItem(0);
		String product2=c.getProductItem(1);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		CheckoutPage2 c2=new CheckoutPage2(driver);
	    Assert.assertEquals(c2.getProductItem(0), product1,"First product is not transferred correctly");
	    Assert.assertEquals(c2.getProductItem(1),product2,"Second product is not transferred correctly");
	    
	}
}
