package ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage1 {
WebDriver driver;

public CheckoutPage1(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

@FindBy(id = "first-name")
private WebElement firstName;

@FindBy(id = "last-name")
private WebElement lastName;

@FindBy(id = "postal-code")
private WebElement postalCode;

@FindBy(id = "continue")
private WebElement continuebt;

@FindBy(xpath = "//h3[text()='Error: First Name is required']")
private WebElement errorMessage;

@FindBy(id = "cancel")
private WebElement cancel;


@FindBy(className = "title")
private WebElement checkoutInformation;

public void getFirstName(String value) {
	firstName.sendKeys(value);
}

public void getLastName(String value) {
	lastName.sendKeys(value);
}

public void getPostalCode(String value) {
	postalCode.sendKeys(value);
}

public void getContinuebt() {
	continuebt.click();
}

public void CheckoutDetails(String fn,String ln, String pc) throws InterruptedException
{
	firstName.sendKeys(fn);
	lastName.sendKeys(ln);
	postalCode.sendKeys(pc);
	continuebt.click();
	Thread.sleep(2000);
}

public String getErrorMessage() {
	return errorMessage.getText();
}

public void getCancel() {
	cancel.click();
}

public boolean isCheckoutInformationDisplayed() {
    return checkoutInformation.isDisplayed();
}

public boolean isFirstNameDisplayed() {
	return firstName.isDisplayed();
}

public boolean isLastNameNameDisplayed() {
	return lastName.isDisplayed();
}

public boolean isPostalCodeDisplayed() {
	return postalCode.isDisplayed();
}

public boolean isContinueDisplayed() {
	return continuebt.isDisplayed();
}

public boolean isCancelDisplayed() {
	return cancel.isDisplayed();
	
}

public boolean isErrorDisplayed()
{
	return errorMessage.isDisplayed();
}

}
