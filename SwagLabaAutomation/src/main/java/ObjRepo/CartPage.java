package ObjRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
 WebDriver driver;

 public CartPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
 }
 @FindBy(className = "inventory_item_name")
 private List<WebElement>  productItem;
 
 @FindBy(id="checkout")
 private WebElement checkoutbt;
 
 @FindBy(xpath = "(//button[text()='Remove'])")
 private List<WebElement> removebt;

 public String getProductItem(int index) { 
	return productItem.get(index).getText();
 }

 public void getCheckoutbt() {
	checkoutbt.click();
 }
 public int getProductCount()
 {
 	return productItem.size();
 }
 public void getRemoveBt(int index) {
	 removebt.get(index).click();
 }

}
