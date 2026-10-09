package ecom.SwagLabs_Checkout;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.ExcelUtility;
import ObjRepo.CartPage;
import ObjRepo.CheckoutPage1;
import ObjRepo.CheckoutPage2;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Checkout_Functional extends BaseClass {
  @Test(priority=1 , groups ="functional")
  public void tc_001() throws InterruptedException
  {
	  ProductPage p=new ProductPage(driver);
	  p.selectingSorting("Price (low to high)");
	  p.getAddToCart(0);
	  Thread.sleep(2000);
	  HomePage h=new HomePage(driver);
	  h.getCart();
	  Thread.sleep(2000);
	  CartPage c=new CartPage(driver);
	 String actualProduct= c.getProductItem(0);
	 Assert.assertEquals(actualProduct, "Sauce Labs Onesie");
	 c.getCheckoutbt();
	 CheckoutPage1 c1=new CheckoutPage1(driver);
	 String actualUrl=driver.getCurrentUrl();
	 Assert.assertTrue(actualUrl.contains("https://www.saucedemo.com/checkout-step-one.html"));  
  }
  
  @Test(priority=2 , groups ="functional")
  public void tc_002() throws InterruptedException, IOException{
	  ProductPage p=new ProductPage(driver);
	  p.selectingSorting("Price (low to high)");
	  p.getAddToCart(1);
	  Thread.sleep(2000);
	  HomePage h=new HomePage(driver);
	  h.getCart();
	  Thread.sleep(2000);
	  CartPage c=new CartPage(driver);
	//  System.out.println(c.getProductItem(1));
	 c.getCheckoutbt();
	 CheckoutPage1 c1=new CheckoutPage1(driver);
	 ExcelUtility e=new ExcelUtility();
	 e.openExcel();
	 String fn=e.getData("Sheet1", 1, 0);
	 String ln=e.getData("Sheet1", 1, 1);
	 String postalcode=e.getData("Sheet1", 1, 2).toString();
	 c1.getFirstName(fn);
	 c1.getLastName(ln);
	 c1.getPostalCode(postalcode);
	 c1.getContinuebt();
	 CheckoutPage2 c2=new CheckoutPage2(driver);
	 //String verifyPageByVisibleProduct=c2.getProductItem(0);
	 String verifyPageByVisibleProduct=c2.getProductItem(1);
	 Assert.assertEquals(verifyPageByVisibleProduct, "Sauce Labs Bolt T-Shirt"); 
  }
}
