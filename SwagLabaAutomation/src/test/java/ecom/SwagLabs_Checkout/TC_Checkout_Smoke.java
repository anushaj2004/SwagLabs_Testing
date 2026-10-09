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

public class TC_Checkout_Smoke extends BaseClass {
@Test(priority = 7, groups = "smoke")
public void tc_007() throws InterruptedException, IOException {
	ProductPage p=new ProductPage(driver);
	p.selectingSorting("Price (low to high)");
	p.getAddToCart(2);
	Thread.sleep(2000);
	HomePage h=new HomePage(driver);
	h.getCart();
	Thread.sleep(2000);
	CartPage c=new CartPage(driver);
	c.getCheckoutbt();
	Thread.sleep(2000);
	CheckoutPage1 c1= new CheckoutPage1(driver);
	Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"), "Checkout Information page is not displayed");
	
	//verify mandatory fields
	
	Assert.assertTrue(c1.isFirstNameDisplayed(), "First Name field is not dispalyed");
	Assert.assertTrue(c1.isLastNameNameDisplayed(), "Last Name field is not dispalyed");
	Assert.assertTrue(c1.isPostalCodeDisplayed(), "Postal Code field is not dispalyed");
	Assert.assertTrue(c1.isContinueDisplayed(), "Continue button is not dispalyed");
	Assert.assertTrue(c1.isCancelDisplayed(), "Cancel button field is not dispalyed");
	
}

@Test(priority = 8, groups = "smoke")
public void tc_008() throws InterruptedException, IOException {
	ProductPage p=new ProductPage(driver);
	p.selectingSorting("Price (low to high)");
	p.getAddToCart(2);
	Thread.sleep(2000);
	HomePage h=new HomePage(driver);
	h.getCart();
	Thread.sleep(2000);
	CartPage c=new CartPage(driver);
	c.getCheckoutbt();
	Thread.sleep(2000);
	CheckoutPage1 c1= new CheckoutPage1(driver);
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
	Assert.assertTrue(c2.isCheckoutOverviewDisplayed());
	Assert.assertTrue(c2.isQuantityDisplayed());
	Assert.assertTrue(c2.isProductPriceDisplayed());
	Assert.assertTrue(c2.isPaymentInformationDisplayed());
	Assert.assertTrue(c2.isShippingInformationDisplayed());
	Assert.assertTrue(c2.isItemTotalDisplayed());
	Assert.assertTrue(c2.isTaxDisplayed());
	Assert.assertTrue(c2.isTotalDisplayed());
	Assert.assertTrue(c2.isFinishDisplayed());
	Assert.assertTrue(c2.isCancelDisplayed());
	c2.getFinishBt();
	Assert.assertTrue(
	        driver.getCurrentUrl().contains("checkout-complete.html"),
	        "Order was not completed successfully"
	);
}
}
