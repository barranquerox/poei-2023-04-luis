package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

  By cartItemBy = By.cssSelector("#activeCartViewForm .sc-list-item");

  By productTitleBy = By.cssSelector(".sc-product-title");

  By quantityBy = By.cssSelector("#quantity");

  private final WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getProductTitle(int index) {
    WebElement cartItem = driver.findElements(cartItemBy).get(index);
    return cartItem.findElement(productTitleBy).getText();
  }

  public CartPage updateQuantity(int productIndex, int newQuantity) {
    WebElement quantitySelectTag = driver.findElements(quantityBy).get(productIndex);
    Select dropdownQuantity = new Select(quantitySelectTag);
    dropdownQuantity.selectByIndex(newQuantity);
    return this;
  }
}
