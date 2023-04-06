package pageobjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  By searchBarLocator = By.cssSelector("#twotabsearchtextbox");

  By listAndAccountButtonBy = By.cssSelector("#nav-link-accountList");

  By signInButtonBy = By.cssSelector(".nav-action-button");

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

  public void createNewAccount() {
    Actions actions = new Actions(driver);

    WebElement buttonAccount = driver.findElement(listAndAccountButtonBy);
    actions.moveToElement(buttonAccount);
    actions.perform();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(ExpectedConditions.elementToBeClickable(signInButtonBy)).click();
  }
}
