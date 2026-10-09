package ecom.SwagLabs_Cart;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtitlity.ScreenshotUtility;
import ObjRepo.CartPage;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Cart_Functional extends BaseClass{

	@Test(groups = "functional")
	public void tc_001() throws IOException
	{
		ProductPage p=new ProductPage(driver);
		p.getAddToCart(0);
		HomePage h=new HomePage(driver);
		h.getCart();
		CartPage c=new CartPage(driver);
		Assert.assertEquals(c.getProductCount(),1,"Product is not added to cart");
		ScreenshotUtility.takeScreenshot(driver, "TC_Cart_ProductAdded");
	}
}
