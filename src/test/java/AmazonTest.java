import java.util.concurrent.TransferQueue;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;

public class AmazonTest {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://www.amazon.fr");
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }

  @Test
  public void testAmazon() {
    String keyword = "Apple iPhone 14 Pro (512 Go) - Violet Intense";

    HomePage homePage = new HomePage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    homePage.closeCookiePopup();
    homePage.search(keyword);
    searchResultPage.openSearchResult(0);
    productPage.addToCart();
    Assert.assertEquals(cartPage.getProductTitle(0), keyword);
  }
}
