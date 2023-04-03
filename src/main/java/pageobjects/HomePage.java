package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

  By searchBarLocator = By.cssSelector("#twotabsearchtextbox");
  WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void search(String keyword) {
    driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
  }
}
