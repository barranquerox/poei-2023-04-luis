import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
  
  public void testGoogle() {
    driver.findElements(By.cssSelector("button > [role=none]")).get(3).click();
    driver.findElement(By.cssSelector("[name=q]")).sendKeys("POEI Testeur" + Keys.ENTER);
  }
}
