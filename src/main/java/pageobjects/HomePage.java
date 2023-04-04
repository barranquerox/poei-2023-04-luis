package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

  By searchBarLocator = By.cssSelector("#twotabsearchtextbox");

  By cookieAcceptButtonLocator = By.cssSelector("#sp-cc-accept");
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public SearchResultPage search(String keyword) {
    driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
    return new SearchResultPage(driver);
  }

  public HomePage closeCookiePopup() {
    driver.findElement(cookieAcceptButtonLocator).click();
    return this;
  }
}
