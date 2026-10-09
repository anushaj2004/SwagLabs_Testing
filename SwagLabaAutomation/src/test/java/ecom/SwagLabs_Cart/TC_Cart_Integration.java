package ecom.SwagLabs_Cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjRepo.CartPage;
import ObjRepo.HomePage;
import ObjRepo.ProductPage;
import base.BaseClass;

public class TC_Cart_Integration extends BaseClass{
@Test(groups = "integration")
public void tc_003(){
	ProductPage p=new ProductPage(driver);
	
	String selectedProduct=p.getProductName(0);
	p.getAddToCart(0);
	HomePage h=new HomePage(driver);
	h.getCart();
	CartPage c=new CartPage(driver);
	String cartProduct=c.getProductItem(0);
	Assert.assertEquals(cartProduct,selectedProduct,"Selected product is not correctly transferred to cart");
}
}
