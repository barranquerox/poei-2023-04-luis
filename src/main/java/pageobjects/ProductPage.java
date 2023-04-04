package pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

  By addToCartButtonBy = By.cssSelector("#add-to-cart-button");
  By noCoverageButtonBy = By.cssSelector("#attachSiNoCoverage");

  By openCartButtonBy = By.cssSelector("#attach-sidesheet-view-cart-button");



  private final WebDriver driver;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
  }

  public CartPage addToCartAndOpenCart() {
    clickCartButton();
    return new CartPage(driver);
  }

  public ProductPage addToCart() {
    clickCartButton();
    return this;
  }

  private void clickCartButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driver.findElement(addToCartButtonBy).click();

    wait.until(ExpectedConditions.elementToBeClickable(noCoverageButtonBy)).click();
    wait.until(ExpectedConditions.elementToBeClickable(openCartButtonBy)).click();
  }
}
