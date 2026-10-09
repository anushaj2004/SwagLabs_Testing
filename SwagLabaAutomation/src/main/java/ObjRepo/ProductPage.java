package ObjRepo;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
WebDriver driver;
public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//select[@class='product_sort_container']")
private WebElement sort;

@FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
private List<WebElement> addToCart;

@FindBy(className = "inventory_item_name")
private List<WebElement> productNames;

public String getProductName(int index) {
    return productNames.get(index).getText();
}
public void selectingSorting(String sortVText) {
	Select sel = new Select(sort);
	sel.selectByVisibleText(sortVText);
}

public void getAddToCart(int index) {
	addToCart.get(index).click();
}



 
 
 

}
