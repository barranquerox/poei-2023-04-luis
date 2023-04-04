package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

  By cartItemBy = By.cssSelector("#activeCartViewForm .sc-list-item");

  By productTitleBy = By.cssSelector(".sc-product-title");

  private final WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getProductTitle(int index) {
    WebElement cartItem = driver.findElements(cartItemBy).get(index);
    return cartItem.findElement(productTitleBy).getText();
  }
}
