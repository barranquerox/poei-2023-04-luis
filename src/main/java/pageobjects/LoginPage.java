package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

  WebDriver driver;

  By emailTextboxBy = By.cssSelector("#email");
  By passwordTextboxBy = By.cssSelector("#password");
  By loginButtonBy = By.cssSelector("#loginButton");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage login(String email, String password) {
    fillLoginForm(email, password);
    return new HomePage(driver);
  }

  public LoginPage unsuccessfulLogin(String email, String password) {
    fillLoginForm(email, password);
    return this;
  }

  private void fillLoginForm(String email, String password) {
    driver.findElement(emailTextboxBy).sendKeys(email);
    driver.findElement(passwordTextboxBy).sendKeys(password);
    driver.findElement(loginButtonBy).click();
  }


}
