package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
  WebDriver driver;

  By searchResultLocator = By.cssSelector("[data-component-type=s-search-result]");

  public SearchResultPage(WebDriver driver) {
    this.driver = driver;
  }

  public ProductPage openSearchResult(int index) {
    driver.findElements(searchResultLocator).get(index).click();
    return new ProductPage(driver);
  }
}
