import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PreorderZeldaTest {

  WebDriver driver;
  static final int TIMEOUT_SIDE_PANEL = 5; // 5s

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }


  public void secondAmazonTest() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));

    String url = "https://www.amazon.fr";
    String firstItemExpected = "The Legend of Zelda : Tears of the Kingdom";
    String expectedPrice = "54.99";
    String expectedMessage = "Cet article paraîtra le 12 mai 2023.";

    driver.get(url); // Open 'www.amazon.fr'
    driver.findElement(By.id("sp-cc-accept")).click(); // Close cookie modal
    driver.findElement(By.id("nav-hamburger-menu")).click(); // Open Toutes menu
    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-menu-id='12']"))); // [data-ref-tag='nav_em_1_1_1_17']
    button.click(); // Select 'Jeux video et consoles'
    driver.findElement(By.cssSelector("ul.hmenu.hmenu-visible.hmenu-translateX > li a[class='hmenu-item']")).click(); // Select 'Tous les jeux video'

    WebElement proposalItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-cel-widget='handsfree-browse_OctopusBestSellerAsin'] span.a-list-item"))); // [data-cel-widget='handsfree-browse_OctopusBestSellerAsin'] > div div ul li span.a-list-item
    String firstItemActual = proposalItem.getText();
    Assert.assertTrue(firstItemActual.contains(firstItemExpected), "The first article in 'Les Meilleures Ventes' is not 'The Legend of Zelda : Tears of the Kingdom'"); // Assert that the first article in 'Les Meilleures Ventes' is 'The Legend of Zelda : Tears of the Kingdom'
    proposalItem.click(); // Open the first article

    String actualPrice = driver.findElement(By.cssSelector("span.a-price.aok-align-center > span span.a-price-whole")).getText() + "." + driver.findElement(By.cssSelector("span.a-price.aok-align-center > span span.a-price-fraction")).getText();
    Assert.assertEquals(expectedPrice, actualPrice, "The price is not " + expectedPrice); // Assert that the price is '54.99'

    String actualMessage = driver.findElement(By.cssSelector("#availability span")).getText();
    Assert.assertEquals(expectedMessage, actualMessage, "The messages are not the same"); // Assert the message 'Cet article paraîtra le 12 mai 2023.'
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

}
