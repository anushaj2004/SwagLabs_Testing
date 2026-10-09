package ecom.SwagLabs_Cart;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjRepo.CartPage;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Cart_Negative extends BaseClass {
	
	@Test(priority = 1, groups = {"Integration","Negative"})
	public void tc_004() throws IOException, InterruptedException
	{
		HomePage h=new HomePage(driver);
	    Thread.sleep(2000);
		h.getCart();
		CartPage c=new CartPage(driver);
		Thread.sleep(2000);
		Assert.assertEquals(c.getProductCount(),0,"cart is displayeing a product item even though no product was added");
		
	}
	@Test(priority = 2, groups = {"functional","Negative"})
	public void tc_002() throws IOException, InterruptedException
	{
		ProductPage p=new ProductPage(driver);
		Thread.sleep(2000);
		p.getAddToCart(0);
		HomePage h=new HomePage(driver);
		h.getCart();
		CartPage c=new CartPage(driver);
		Assert.assertEquals(c.getProductCount(),1,"Product is not added to cart");
		Thread.sleep(2000);
		c.getRemoveBt(0);
		Assert.assertEquals(c.getProductCount(),0,"Product is still in cart after removal");
	}
}
